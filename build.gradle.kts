plugins {
    // Use the Java plugin instead of application, as we're building a plugin.
    java
}

group = "com.rrayy"
version = "1.0"
description = "자원 수집을 막는 플러그인"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21)) // Java 21 사용
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") // Spigot API
    maven("https://oss.sonatype.org/content/repositories/snapshots/") // BungeeCord Chat API
    maven("https://repo.xenondevs.xyz/releases") // InvUI 라이브러리
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.21-R0.1-SNAPSHOT") // Spigot API
    compileOnly("xyz.xenondevs.invui:invui:1.44") // InvUI 라이브러리 추가
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}