package models.provider.auth

/**
  * Step 1
  * @param response_type
  * @param scope
  * @param client_id
  * @param state
  * @param redirect_uir
  */
case class AuthenticationRequest(
                                  response_type: String,
                                  scope: String,
                                  client_id: String,
                                  state: String,
                                  redirect_uir: String
                                )
