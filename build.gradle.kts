plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

application {
    mainClass.set("todo.Application")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.run.configure {
    standardInput = System.`in`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.xerial:sqlite-jdbc:3.51.0.0")
    implementation("org.jline:jline:3.30.0")
    implementation("org.jline:jline-terminal-jni:3.30.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveBaseName.set("java-todo")
    archiveClassifier.set("all")
    archiveVersion.set("1.0-SNAPSHOT")

    // release 폴더로 출력
    destinationDirectory.set(file("${projectDir}/release"))

    manifest {
        attributes["Main-Class"] = "todo.Application"
    }
}
