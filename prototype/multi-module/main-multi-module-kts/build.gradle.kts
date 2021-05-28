import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.11.RELEASE"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
//    id("java-library")
    kotlin("jvm") version "1.4.32"
    kotlin("plugin.spring") version "1.4.32"
}

group = "puck.multi.module"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-dependencies:2.3.11.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    implementation(project(":prototype:multi-module:sub-a-multi-module-kts"))
//    implementation(fileTree(mapOf("dir" to "lib", "include" to listOf("*.jar"))))

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//val buildInfo by tasks.registering(BuildInfo::class) {
//    version.set(project.version.toString())
//    outputFile.set(layout.buildDirectory.file("generated-resources/build-info.properties"))
//}
//
//sourceSets {
//    main {
//        output.dir(buildInfo.map { it.outputFile.asFile.get().parentFile })
//    }
//}
