package controllers.provider

import java.security.SecureRandom

import com.google.common.io.BaseEncoding
import com.mohiva.play.silhouette.api.Silhouette
import controllers.AssetsFinder
import io.swagger.annotations.{Api, ApiParam, ApiResponse, ApiResponses}
import javax.inject.{Inject, Singleton}
import org.webjars.play.WebJarsUtil
import play.api.i18n.I18nSupport
import play.api.libs.json.Json
import play.api.mvc._
import utils.Logger
import utils.auth.CookieEnv

import scala.concurrent.Future
@Api(value = "/auth")
@Singleton
class LoginController @Inject()(
  components: ControllerComponents,
  silhouette: Silhouette[CookieEnv])(
  implicit
  webJarsUtil: WebJarsUtil,
  assets: AssetsFinder
)extends AbstractController(components) with I18nSupport with Logger {


  /**
    * Handles the index action.
    * https://accounts.google.com/o/oauth2/v2/auth?
    * redirect_uri=https://developers.google.com/oauthplayground&
    * prompt=consent&response_type=code&client_id=407408718192.apps.googleusercontent.com&scope=&access_type=offline
    * @return The result to display.
    */
  @ApiResponses(Array(
    new ApiResponse(code = 302, message = "ok"),
    new ApiResponse(code = 401, message = "Invalid client id"),
    new ApiResponse(code = 400, message = "Invalid ID supplied"),
    new ApiResponse(code = 404, message = "Pet not found")))
  def auth(@ApiParam(value = "what does the client want to access?", example = "profile email") scope: String,
           @ApiParam(value = "Client ID", example = "client1") client_id: String,
//           @ApiParam(value = "Client Secret", example = "topsecret") client_secret: String,
           @ApiParam(value = "Response Type", example = "grant") response_type: String,
           @ApiParam(value = "redirect uri", example = "http://localhost:9000/token") redirect_uri: String) = Action.async { request =>

    logger.error(request.toString())

    // TODO parse Authorization header for base 64 encoded clientid and secret.

    Future.successful(Found(s"$redirect_uri?code=$generateSecret"))
  }

  def token = Action.async { request =>
    logger.error(request.toString())
    Future.successful(Found("sd"))
  }

  def generateSecret = {
    val random = new SecureRandom()

    val t = (1 to 64).map { _ =>
      (random.nextInt(75) + 48).toChar
    }.mkString.replaceAll("\\\\+", "/")
    BaseEncoding.base64().encode(t.getBytes())
  }

  def people(access_token: String ) = Action.async {
    Future.successful(Ok(Json.toJson(Json.obj("Test" ->"ASDASD"))))
  }

}