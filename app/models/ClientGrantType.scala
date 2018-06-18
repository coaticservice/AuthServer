package models

import java.util.UUID

import play.api.libs.json.{Json, OFormat}


case class ClientGrantType(
                   clientId: UUID,
                   grantTypeId: Option[UUID]
)

object ClientGrantType {
  implicit val jsonFormat: OFormat[ClientGrantType] = Json.format[ClientGrantType]
}

