plugins {
    `java-library`
    `maven-publish`
}

group = "com.ola.learning"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.24")
//    annotationProcessor("org.projectlombok:lombok:1.18.24")
}

publishing {
    publications {
        create<MavenPublication>("gpr") {
            from(components["java"])
            groupId = "com.ola"
            artifactId = "learn-commons"
            version = "1.0.0"
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

//tasks.test {
//    useJUnitPlatform()
//}