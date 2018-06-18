package controllers.oidc

import com.mohiva.play.silhouette.api.actions.SecuredRequest
import com.mohiva.play.silhouette.api.{LogoutEvent, Silhouette}
import controllers.AssetsFinder
import javax.inject.{Inject, Singleton}
import org.webjars.play.WebJarsUtil
import play.api.i18n.I18nSupport
import play.api.mvc._
import utils.auth.CookieEnv

import scala.concurrent.Future

@Singleton
class LoginController @Inject()(
  components: ControllerComponents,
  silhouette: Silhouette[CookieEnv])(
  implicit
  webJarsUtil: WebJarsUtil,
  assets: AssetsFinder
)extends AbstractController(components) with I18nSupport {

  /**
    * Handles the index action.
    *
    * @return The result to display.
    */
  def login = Action.async { implicit request: Request[AnyContent] =>
    Future.successful(Found("sd"))
  }

  def cb = Action.async { implicit request: Request[AnyContent] =>
    Future.successful(Found("sd"))
  }

}