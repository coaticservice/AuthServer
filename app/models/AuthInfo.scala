package models

import java.util.UUID

import play.api.libs.json.{Json, OFormat}

case class AuthInfo(
                   id: UUID,
                   userId: UUID,
                   clientId: String,
                   scope: String,
                   refreshToken: String,
                   code: String,
                   redirectUri: String
                   )

object AuthInfo {
  implicit val jsonFormat: OFormat[AuthInfo] = Json.format[AuthInfo]
}
