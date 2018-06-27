package models.provider.client

import formatters.json.EnumUtils
import play.api.libs.json.{Reads, Writes}

object AppType extends Enumeration {

  type AppType = Value

  val WEB, APP = Value

  implicit val lensStateReads: Reads[AppType] = EnumUtils.enumReads(AppType)

  implicit def lensStateWrites: Writes[AppType] = EnumUtils.enumWrites
}
