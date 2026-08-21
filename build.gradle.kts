plugins {
    id("java-library")
    id("com.gradleup.shadow") version "9.0.0"
    id("xyz.jpenilla.run-paper") version "3.1.0"
    id("maven-publish")
}
    repositories {
        mavenCentral()

        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://repo.codemc.io/repository/maven-releases/")
        maven("https://repo.codemc.io/repository/maven-snapshots/")
        maven { url = uri("https://jitpack.io") }
    }


dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.11-R0.1-SNAPSHOT")
    compileOnly(project(":ElementSMPRefined"))
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

tasks {
    shadowJar {
        dependsOn(":ElementSMPRefined:shadowJar")
        archiveClassifier.set("")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        minimize()
        mergeServiceFiles()
    }

    // Re-enabled: JitPack (and anyone else consuming this as a library) needs the
    // plain `jar` output to publish. Nothing is actually bundled/shaded today (no
    // implementation deps), so this is content-equivalent to shadowJar anyway.
    // The deployed plugin jar you drop on a server should still be shadowJar's output.

    runServer {
        minecraftVersion("1.21.11")
        jvmArgs("-Xms2G", "-Xmx2G")
    }

    processResources {
        val props = mapOf("version" to version)

        filesMatching("plugin.yml") {
            expand(props)
        }
    }
}