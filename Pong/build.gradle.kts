import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
}

group = "pt.isel.pg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    flatDir { dirs("libs") }  // Adicionar esta linha
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("pt.isel:CanvasLib-jvm:1.0.1") // Adicionar esta linha
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}