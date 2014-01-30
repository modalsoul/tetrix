lazy val buildSettings = Seq(
	version := "0.1.0-SNAPSHOT",
	organization := "jp.modal.soul",
	licenses := Seq("MIT License" -> url("http://opensource.org/licenses/mit-license.php/")),
	scalaVersion := "2.10.3",
	scalacOptions := Seq("-deprecation", "-unchecked"),
	resolvers += Resolver.sonatypeRepo("public")
)

lazy val swingDependencies = Def.setting {
	"org.scala-lang" % "scala-lang" % scalaVersion.value
}

lazy val root = (project in file(".")).
	settings(buildSettings: _*).
	settings(name := "tetrix.scala")

lazy val library = (project in file("library")).
	settings(buildSettings: _*)

lazy val swing = (project in file("swing")).
	settings(buildSettings: _*).
	settings(
		fork in run := true,
		libraryDependencies += swingDependencies.value
	).
	dependsOn(library)