package service

import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.api.util.HTTPLayer
import com.mohiva.play.silhouette.impl.exceptions.ProfileRetrievalException
import com.mohiva.play.silhouette.impl.providers._
import service.LocalhostProvider._
import play.api.libs.json.{JsObject, JsValue}

import scala.concurrent.Future

/**
  * Base Localhost OAuth2 Provider.
  *
  * @see https://developers.Localhost.com/+/api/auth-migration#timetable
  * @see https://developers.Localhost.com/+/api/auth-migration#oauth2login
  * @see https://developers.Localhost.com/accounts/docs/OAuth2Login
  * @see https://developers.Localhost.com/+/api/latest/people
  */
trait BaseLocalhostProvider extends OAuth2Provider {

  /**
    * The content type to parse a profile from.
    */
  override type Content = JsValue

  /**
    * The provider ID.
    */
  override val id = ID

  /**
    * Defines the URLs that are needed to retrieve the profile data.
    */
  override protected val urls = Map("api" -> settings.apiURL.getOrElse(API))

  /**
    * Builds the social profile.
    *
    * @param authInfo The auth info received from the provider.
    * @return On success the build social profile, otherwise a failure.
    */
  override protected def buildProfile(authInfo: OAuth2Info): Future[Profile] = {
    httpLayer.url(urls("api").format(authInfo.accessToken)).get().flatMap { response =>
      val json = response.json
      (json \ "error").asOpt[JsObject] match {
        case Some(error) =>
          val errorCode = (error \ "code").as[Int]
          val errorMsg = (error \ "message").as[String]

          throw new ProfileRetrievalException(SpecifiedProfileError.format(id, errorCode, errorMsg))
        case _ => profileParser.parse(json, authInfo)
      }
    }
  }
}

/**
  * The profile parser for the common social profile.
  */
class LocalhostProfileParser extends SocialProfileParser[JsValue, CommonSocialProfile, OAuth2Info] {

  /**
    * Parses the social profile.
    *
    * @param json     The content returned from the provider.
    * @param authInfo The auth info to query the provider again for additional data.
    * @return The social profile from given result.
    */
  override def parse(json: JsValue, authInfo: OAuth2Info) = Future.successful {
    val userID = (json \ "id").as[String]
    val firstName = (json \ "name" \ "givenName").asOpt[String]
    val lastName = (json \ "name" \ "familyName").asOpt[String]
    val fullName = (json \ "displayName").asOpt[String]
    val avatarURL = (json \ "image" \ "url").asOpt[String]

    // https://developers.Localhost.com/+/api/latest/people#emails.type
    val emailIndex = (json \ "emails" \\ "type").indexWhere(_.as[String] == "account")
    val emailValue = if ((json \ "emails" \\ "value").isDefinedAt(emailIndex)) {
      (json \ "emails" \\ "value")(emailIndex).asOpt[String]
    } else {
      None
    }

    CommonSocialProfile(
      loginInfo = LoginInfo(ID, userID),
      firstName = firstName,
      lastName = lastName,
      fullName = fullName,
      avatarURL = avatarURL,
      email = emailValue)
  }
}

/**
  * The Localhost OAuth2 Provider.
  *
  * @param httpLayer     The HTTP layer implementation.
  * @param stateHandler  The state provider implementation.
  * @param settings      The provider settings.
  */
class LocalhostProvider(
                      protected val httpLayer: HTTPLayer,
                      protected val stateHandler: SocialStateHandler,
                      val settings: OAuth2Settings)
  extends BaseLocalhostProvider with CommonSocialProfileBuilder {

  /**
    * The type of this class.
    */
  type Self = LocalhostProvider

  /**
    * The profile parser implementation.
    */
  val profileParser = new LocalhostProfileParser

  /**
    * Gets a provider initialized with a new settings object.
    *
    * @param f A function which gets the settings passed and returns different settings.
    * @return An instance of the provider initialized with new settings.
    */
  def withSettings(f: (Settings) => Settings) = new LocalhostProvider(httpLayer, stateHandler, f(settings))
}

/**
  * The companion object.
  */
object LocalhostProvider {

  /**
    * The error messages.
    */
  val SpecifiedProfileError = "[Silhouette][%s] Error retrieving profile information. Error code: %s, message: %s"

  /**
    * The Localhost constants.
    */
  val ID = "localhost"
  val API = "http://localhost:9000/v1/people/me?access_token=%s"
}
