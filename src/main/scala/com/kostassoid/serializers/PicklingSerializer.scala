package com.kostassoid.serializers

import scala.pickling.Defaults._
import scala.pickling.json._
import scala.reflect.ClassTag

class PicklingSerializer extends CanSerialize {

  override def write[T <: AnyRef : ClassTag](obj: T): String = {
    obj.asInstanceOf[Any].pickle.value
  }

  override def read[T <: AnyRef : ClassTag](raw: String): T = {
    ???
    //pickling.json.toJSONPickle(raw).unpickle(PicklerUnpickler.generate[T], pickleFormat)
  }
}
