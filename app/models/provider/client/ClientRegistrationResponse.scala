package models.provider.client

import ClientApplicationType.ClientApplicationType
import org.joda.time.DateTime


// Missing values from spec: https://openid.net/specs/openid-connect-registration-1_0.html#RegistrationRequest
case class ClientRegistrationResponse(client_id: String,
                                      client_secret: String,
                                      client_secret_expires_at: DateTime,
                                      registration_access_token: String, // client must use this. JWT
                                      registration_client_uri: String,
                                      redirect_uris: Seq[String],
                                      application_type: ClientApplicationType,
                                      client_name: String,
                                      logo_uri: Option[String]
)

// AccessToken CONTENT
//{
//  "alg": "RS256",
//  "typ": "JWT"
//}
//  .
//{
//  "iss": "https://example.auth0.com/",
//  "aud": "https://api.example.com/calandar/v1/",
//  "sub": "usr_123",
//  "scope": "read write",
//  "iat": 1458785796,
//  "exp": 1458872196
