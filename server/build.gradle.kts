plugins {
    id("yebali.kotlin.spring-web.jpa")
    id("com.google.protobuf") version "0.9.4"
}

group = "com.yebali.template.server"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // gRPC 및 Protobuf 관련 의존성
    implementation("io.grpc:grpc-netty:1.57.2")
    implementation("io.grpc:grpc-protobuf:1.57.2")
    implementation("io.grpc:grpc-stub:1.57.2")
    implementation("io.grpc:grpc-kotlin-stub:1.4.1")

    // Protocol Buffers (Protobuf)
    implementation("com.google.protobuf:protobuf-java:4.28.2")

    // Kotlin 런타임 및 유틸리티
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("net.devh:grpc-spring-boot-starter:2.15.0.RELEASE")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:4.28.2"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.57.2"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                create("grpc")
            }
        }
    }
}
