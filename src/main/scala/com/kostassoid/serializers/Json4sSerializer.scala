package com.kostassoid.serializers

import org.json4s._
import org.json4s.jackson.Serialization

import scala.reflect.ClassTag

class Json4sSerializer extends CanSerialize {

  implicit val formats = Serialization.formats(NoTypeHints)

  override def write[T <: AnyRef : ClassTag](obj: T): String = {
    Serialization.write(obj)
  }

  override def read[T <: AnyRef : ClassTag](raw: String): T = {
    Serialization.read[Any](raw).asInstanceOf[T]
  }
}
