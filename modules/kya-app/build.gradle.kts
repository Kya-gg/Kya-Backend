repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":modules:kya-football:kya-football-api"))
    implementation(project(":modules:kya-football:kya-football-collector"))
    implementation(project(":modules:kya-football:kya-football-common"))
}