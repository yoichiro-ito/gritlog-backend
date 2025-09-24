plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

group = "app.gritlog"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(project(":application"))
    implementation(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.11")

    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    runtimeOnly(project(":infrastructure"))

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

springBoot {
    mainClass.set("app.gritlog.GritlogBackendApplicationKt")
}

tasks.processResources {
    from("../mysql/init") {
        include("schema.sql")
        into(".") // -> presentation/src/main/resources/schema.sql へ出力
    }
    from("src/main/resources/db") {
        include("data.sql")
        into(".")           // -> presentation/src/main/resources/data.sql
    }
}
