plugins {
    id("java")
}

group = "br.com.leandro"
version = "1.0-SNAPSHOT"
val autoServiceVersion = "1.1.1"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("com.google.auto.service:auto-service:$autoServiceVersion")
    annotationProcessor("com.google.auto.service:auto-service:$autoServiceVersion")
    implementation("com.squareup:javapoet:1.13.0")

    compileOnly(project(":annotation"))
    implementation(project(":annotation"))
}
