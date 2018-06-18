package models.provider.auth

/**
  * Step 2
  * @param code
  * @param state
  */
case class AuthenticationResponse(
                                 code: String,
                                 state: String
                                 )