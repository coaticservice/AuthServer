package models.provider.client

object TokenEndpointAuthMethod extends Enumeration {

  type TokenEndpointAuthMethod = Value

  val None, ClientSecretPost, ClientSecretBasic = Value
}
