repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":modules:kya-football:kya-football-common"))

    implementation("org.springframework.boot:spring-boot-starter-webflux:3.3.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
}