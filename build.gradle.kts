plugins {
    id("net.neoforged.moddev") version "2.0.30-beta"
    id("com.almostreliable.almostgradle") version "1.1.1"
}

almostgradle.setup {
    withSourcesJar = false
}

repositories {
    // KubeJS
    maven("https://maven.latvian.dev/releases")
    maven("https://jitpack.io") { // Animated Gif Library
        content {
            includeGroup("com.github.rtyley")
        }
    }

    // CurseMaven (Actually Additions)
    maven("https://cursemaven.com")

    mavenLocal()
}

dependencies {
    // KubeJS
    implementation("dev.latvian.mods:kubejs-neoforge:${almostgradle.getProperty("kjsVersion")}")

    // Actually Additions
    implementation("curse.maven:actually-additions-228404:5835183") // 1.3.6
    // implementation("de.ellpeck.actuallyadditions:ActuallyAdditions:${almostgradle.getProperty("aaVersion")}+mc${almostgradle.minecraftVersion}") {
    //     isTransitive = false
    // }
}
