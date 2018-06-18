package models.provider.client

object ClientApplicationType extends Enumeration {

  type ClientApplicationType = Value

  val Native, Spa, RegularWeb, NonInteractive  = Value
}
