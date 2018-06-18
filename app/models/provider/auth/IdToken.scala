package models.provider.auth

import org.joda.time.DateTime

case class IdToken(
                    sub: String,
                    iss: String,
                    aud: String,
                    nonce: String,
                    auth_time: DateTime,
                    acr: String,
                    iat: DateTime,
                    exp: DateTime,
                  )