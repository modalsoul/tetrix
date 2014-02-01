lazy val buildSettings = Seq(
	version := "0.1.0-SNAPSHOT",
	organization := "jp.modal.soul",
	licenses := Seq("MIT License" -> url("http://opensource.org/licenses/mit-license.php/")),
	scalaVersion := "2.10.3",
	scalacOptions := Seq("-deprecation", "-unchecked"),
	resolvers += Resolver.sonatypeRepo("public")
)

lazy val swingDependencies = Def.setting {
	"org.scala-lang" % "scala-swing" % scalaVersion.value
}

lazy val root = (project in file(".")).
	settings(buildSettings: _*).
	settings(name := "tetrix.scala")

lazy val library = (project in file("library")).
	settings(buildSettings: _*).
	settings(libraryDependencies += libDeps.value)

lazy val swing = (project in file("swing")).
	settings(buildSettings: _*).
	settings(
		fork in run := true,
		libraryDependencies += swingDependencies.value
	).
	dependsOn(library)

lazy val specs2Version = "2.2.2"
lazy val libDeps = Def.setting {
	"org.specs2" %% "specs2" % specs2Version % "test"
}
