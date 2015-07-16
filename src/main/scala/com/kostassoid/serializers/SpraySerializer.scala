package com.kostassoid.serializers

import spray.json._

import scala.reflect.ClassTag

class SpraySerializer extends CanSerialize {

  object Protocol extends DefaultJsonProtocol {
  }

  override def write[T <: AnyRef : ClassTag](obj: T): String = {
    ???
    //obj.toJson.toString()
  }

  override def read[T <: AnyRef : ClassTag](raw: String): T = {
    ???
    //raw.parseJson
  }
}
