plugins {
    kotlin("jvm") version "2.1.0"
    `java-library`
    `maven-publish`
}
val javaVersion = JavaVersion.VERSION_17.toString()

group = "com.ola.learning"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
}

publishing {
    publications {
        create<MavenPublication>("gpr") {
            from(components["java"])
            groupId = "com.ola"
            artifactId = "learn-commons"
            version = "1.0.2"
        }
    }
    repositories {
        maven {
            name = "little_maven_repo"
            url = uri("https://maven.pkg.github.com/HuuLiang/little_maven_repo")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.token") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}

tasks.withType<JavaCompile> {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
    options.compilerArgs.add("-proc:full")
}

//tasks.register("compileJava", JavaCompile::class) {
//    source = fileTree("src/main/java")
//    classpath = sourceSets["main"].compileClasspath
////    destinationDir = file("build/classes")
//    options.compilerArgs.add("-proc:full")
//}
//tasks.test {
//    useJUnitPlatform()
//}