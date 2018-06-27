package models

import formatters.json.EnumUtils
import play.api.libs.json.{Reads, Writes}

object Role extends Enumeration {

  type Role = Value

  val Admin, User, Unknown = Value

  implicit val lensStateReads: Reads[Role] = EnumUtils.enumReads(Role)

  implicit def lensStateWrites: Writes[Role] = EnumUtils.enumWrites
}