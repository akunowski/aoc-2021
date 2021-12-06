plugins {
    kotlin("jvm") version "1.6.0"
    groovy
}


repositories {
    mavenCentral()
}
dependencies {
    implementation("org.codehaus.groovy:groovy:3.0.8")
    testImplementation("org.spockframework:spock-core:2.0-groovy-3.0")
    testImplementation("org.codehaus.groovy:groovy-all:3.0.8")

}

tasks {
    sourceSets {
        main {
            kotlin {
                java.srcDirs("src/main")
            }
        }

        test {
            groovy {
                java.srcDirs("test/groovy")
            }
        }
    }

    wrapper {
        gradleVersion = "7.3"
    }
}

tasks.test {
    useJUnitPlatform()
}