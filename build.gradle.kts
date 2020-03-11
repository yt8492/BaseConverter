plugins {
    kotlin("js") version "1.3.70"
}

group = "com.yt8492"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

kotlin.target.browser {
    runTask {
        outputFileName = "main.js"
    }
    webpackTask {
        outputFileName = "main.js"
    }
}