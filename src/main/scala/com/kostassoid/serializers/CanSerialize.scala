package com.kostassoid.serializers

import scala.reflect.ClassTag

trait CanSerialize {
  def write[T <: AnyRef : ClassTag](obj: T): String
  def read[T <: AnyRef : ClassTag](raw: String): T
}
