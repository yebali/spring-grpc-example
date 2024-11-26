plugins {
    id("yebali.kotlin.spring-web")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.h2database:h2")
}