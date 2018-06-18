package models

import java.util.UUID

import org.joda.time.DateTime
import play.api.libs.json.{Json, OFormat}

import play.api.libs.json.JodaWrites._
import play.api.libs.json.JodaReads._

case class AccessToken (
                         accessToken: String,
                         refreshToken: Option[String],
                         userId: UUID,
                         scope: Option[String],
                         expires: DateTime,
                         created: DateTime,
                         clientId: UUID)

object AccessToken {
  implicit val jsonFormat: OFormat[AccessToken] = Json.format[AccessToken]
}
