plugins {
    kotlin("jvm")
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

    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    runtimeOnly("com.mysql:mysql-connector-j")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}