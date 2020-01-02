val common = Seq(
  version := "0.1",
  organization := "org.my",
  scalaVersion := "2.13.1",
  testFrameworks += new TestFramework("utest.runner.Framework"),
  libraryDependencies ++= Seq(
  "com.chuusai"        %%% "shapeless" % "2.3.3",
  "org.scala-js"       %%% "scalajs-dom" % "0.9.8",
  "com.lihaoyi"        %%% "utest" % "0.7.2" % "test",
  "com.lihaoyi"        %%% "scalatags" % "0.8.3",
  "com.lihaoyi"        %%% "upickle" % "0.9.6",
  "be.doeraene"        %%% "scalajs-jquery" % "0.9.6"
  )
)

lazy val app = project.in(file("app"))
  .enablePlugins(ScalaJSPlugin)
  .settings(common)
  .settings(
    // This is an application with a main method
    //scalaJSUseMainModuleInitializer := true,
    scalacOptions +=  "-P:scalajs:sjsDefinedByDefault",
    //scalaJSLinkerConfig ~= { _.withESFeatures(_.withUseECMAScript2015(true)) },
    skip in packageJSDependencies := false,
    jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv,
    jsDependencies ++= Seq(
      "org.webjars" % "jquery" % "3.3.1" / "3.3.1/jquery.js",
      "org.webjars.npm" % "rxjs" % "5.4.0" / "bundles/Rx.min.js" commonJSName "Rx"
    )
  ).settings(
    name := "ScalaJS Seed",
  )
