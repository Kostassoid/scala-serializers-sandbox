package com.kostassoid.serializers

import org.scalatest.{BeforeAndAfter, FreeSpec, Matchers}

abstract class SerializerSpec(newSerializer: => CanSerialize) extends FreeSpec with Matchers with BeforeAndAfter {

  @volatile var serializer: CanSerialize = _

  before {
    serializer = newSerializer
  }

  "can serialize string" in {
    val source = "Some string"

    val serialized = serializer.write(source)
    val deserialized = serializer.read[AnyRef](serialized)

    serialized shouldBe "\"Some string\""
    deserialized shouldBe source
  }

  "can serialize List" in {
    val source = "one" :: "two" :: "three" :: Nil

    val serialized = serializer.write(source)
    val deserialized = serializer.read[AnyRef](serialized)

    serialized shouldBe """["one","two","three"]"""
    deserialized shouldBe source
  }
}

class Json4sSpec extends SerializerSpec(new Json4sSerializer)

class SpraySpec extends SerializerSpec(new SpraySerializer)

class PicklingSpec extends SerializerSpec(new PicklingSerializer)

class PicklerSpec extends SerializerSpec(new PicklerSerializer)
