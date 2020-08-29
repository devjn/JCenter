publishing {
    publications {
        register<MavenPublication>("mavenAndroid") {
            artifactId = artifact

            afterEvaluate { artifact(tasks.getByName("bundleReleaseAar")) }
            artifact(tasks.getByName("androidJavadocJar"))
            artifact(tasks.getByName("androidSourcesJar"))

            pom {
                name.set(artifactName)
                description.set(artifactDescription)
                url.set(artifactUrl)

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("devjn")
                        name.set("John")
                        email.set("devjn@jn-arts.com")
                    }
                }
                scm {
                    connection.set(gitUrl)
                    developerConnection.set(gitUrl)
                    url.set(siteUrl)
                }
                
            }
        }
    }

    repositories {
        maven {
            name = "bintray"
            credentials {
                username = Secrets.Bintray.user
                password = Secrets.Bintray.apiKey
            }
            url = uri(bintrayUri)
        }
    }
}
