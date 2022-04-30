import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "example." + project.name
version = "0.0.1"

java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

plugins {
  kotlin("jvm") version "1.6.21"
  kotlin("plugin.spring") version "1.6.21"
  kotlin("plugin.allopen") version "1.6.21"
  kotlin("plugin.noarg") version "1.6.21"
  kotlin("plugin.jpa") version "1.6.21"

  id("org.springframework.boot") version "2.6.7"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.springframework.boot:spring-boot-starter-web-services")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.flywaydb:flyway-core")
  implementation("com.h2database:h2")

  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

buildscript {
  repositories {
    mavenCentral()
  }
}

repositories {
  mavenCentral()
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    languageVersion = "1.6"
    jvmTarget = "17"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
