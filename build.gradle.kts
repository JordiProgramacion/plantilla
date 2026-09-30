plugins {
    // Plugin de Kotlin per a la JVM
    kotlin("jvm") version "2.2.20"

    // Plugin per poder executar l'aplicació amb ./gradlew run
    application

    // Plugin oficial de JavaFX per a Gradle
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    // Repositori on Gradle buscarà les dependències
    mavenCentral()
}

javafx {
    // Versió de JavaFX
    version = "21.0.8"

    // Mòduls de JavaFX que necessita el programa
    modules(
        "javafx.base",
        "javafx.graphics",
        "javafx.controls",
        "javafx.fxml"
    )
}

application {
    // main() de Main.kt
    mainClass.set("MainKt")
}

kotlin {
    // Utilitzem Java 21
    jvmToolchain(21)
}
dependencies {
    implementation(kotlin("stdlib"))
}