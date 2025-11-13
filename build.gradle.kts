plugins {
  kotlin("jvm") version "2.2.20"
  id("com.apollographql.apollo") version "5.0.0-alpha.2"
}

group = "com.yt8492"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))
  val apolloVersion = "5.0.0-alpha.2"
  implementation("com.apollographql.apollo:apollo-runtime:$apolloVersion")
}

tasks.test {
  useJUnitPlatform()
}
kotlin {
  jvmToolchain(17)
}

apollo {
  service("service") {
    packageName.set("com.yt8492.apolloplayground")
    generateSchema.set(true)
    schemaFiles.from("src/main/graphql/schema.graphqls", "src/main/graphql/extra.graphqls")
  }
}
