package models.provider.client

import ClientApplicationType.ClientApplicationType
import TokenEndpointAuthMethod.TokenEndpointAuthMethod



// Missing values from spec: https://openid.net/specs/openid-connect-registration-1_0.html#RegistrationRequest
case class ClientRegistrationRequest(
                             application_type: ClientApplicationType,
                             redirect_uris: Seq[String],
                             client_name: String,
                             logo_uri: Option[String],
                             token_endpoint_auth_method: TokenEndpointAuthMethod,
                             )
