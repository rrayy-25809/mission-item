plugins {
    java
}

group = "com.rrayy"
version = "1.0"
description = "자원 수집을 막는 플러그인"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") // Paper API
    maven("https://repo.xenondevs.xyz/releases") // InvUI 라이브러리
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
    implementation("xyz.xenondevs.invui:invui:1.44") // InvUI 라이브러리 추가
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}