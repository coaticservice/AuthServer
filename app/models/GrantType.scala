package models

import java.util.UUID

import play.api.libs.json.{Json, OFormat}

case class GrantType(id: UUID, grantType: String)

object GrantType {

  implicit val jsonFormat: OFormat[GrantType] = Json.format[GrantType]

}
