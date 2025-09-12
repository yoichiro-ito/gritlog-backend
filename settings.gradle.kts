plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "gritlog-backend"
include("application")
include("domain")
include("presentation")
