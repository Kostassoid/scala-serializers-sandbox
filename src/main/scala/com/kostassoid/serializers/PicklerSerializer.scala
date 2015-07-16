package com.kostassoid.serializers

import io.github.netvl.picopickle.DefaultPickler
import io.github.netvl.picopickle.backends.jawn.JsonPickler

import scala.reflect.ClassTag

class PicklerSerializer extends CanSerialize {

  object CustomPickler extends JsonPickler with DefaultPickler {
    override val defaultDiscriminatorKey: String = "_t"
  }

  override def write[T <: AnyRef : ClassTag](obj: T): String = {
    CustomPickler.writeString[AnyRef](obj)
  }

  override def read[T <: AnyRef : ClassTag](raw: String): T = {
    CustomPickler.readString[AnyRef](raw).asInstanceOf[T]
  }
}
