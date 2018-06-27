package models.provider.auth

import java.util.UUID

import org.joda.time.DateTime

case class AuthenticationModel(
                                auth_token: String,
                                authType: String,
                                userId: UUID,
                                clientId: String,
                                expires: DateTime
                              )
