package models

import java.util.UUID

import play.api.libs.json.{Json, OFormat}


case class Client(
                   id: UUID,
                   clientSecret: Option[String],
                   redirectUir: Option[String],
                   scope: Option[String]
)

object Client {
  implicit val jsonFormat: OFormat[Client] = Json.format[Client]
}
