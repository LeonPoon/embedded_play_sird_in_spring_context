package com.codepowered.tryout.play_sird_in_spring

import com.google.inject.Module
import play.api._
import play.api.inject.guice.{GuiceApplicationBuilder, GuiceableModule}
import play.api.mvc.{DefaultActionBuilder, Results}
import play.api.routing.Router.Routes
import play.api.routing.sird._
import play.api.routing.{Router, SimpleRouter}
import play.core.server.{AkkaHttpServer, Server, ServerConfig}

import javax.inject.Inject


class ScalaSimpleRouter @Inject()(val Action: DefaultActionBuilder, val dummy: DummyInterface) extends SimpleRouter {
  override def routes: Routes = {
    case GET(p"/hello/$to") =>
      Action {
        Results.Ok(s"Hexllo ${if (to.isEmpty) dummy else to}")
      }
    case GET(p"/") =>
      Action {
        Results.Ok(s"$dummy")
      }
  }
}


trait MainBeanTrait {

  val module: Module

  val app: Application = GuiceApplicationBuilder()
    .in(Mode.Test)
    .bindings(GuiceableModule.guiceable(module))
    .overrides(inject.bind[Router].to[ScalaSimpleRouter])
    .build

  def server: Server =
    AkkaHttpServer.fromApplication(
      app,
      ServerConfig(
        port = Some(19000),
        address = "127.0.0.1",
        mode = Mode.Test
      )
    )
}

class MainBean(val module: Module) extends MainBeanTrait {

}
