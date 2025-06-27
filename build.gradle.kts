import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "2.1.20"
    kotlin("plugin.spring") version "2.1.20"
}

repositories {
    mavenCentral()
}


subprojects {
    if (name == "modules") return@subprojects
    if (name == "kya-football") return@subprojects

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    group = "gg.kya"
    version = "0.0.1-SNAPSHOT"

    java {
        sourceCompatibility = JavaVersion.VERSION_17
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")

        implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")


        implementation("com.mysql:mysql-connector-j")
        implementation("org.jetbrains.exposed:exposed-spring-boot-starter:${properties["exposedVersion"]}")
        implementation("org.jetbrains.exposed:exposed-kotlin-datetime:${properties["exposedVersion"]}")

        implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")

        testImplementation("org.springframework.boot:spring-boot-starter-test")

    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }
}
