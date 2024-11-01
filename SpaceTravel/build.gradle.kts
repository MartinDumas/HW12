plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/com.h2database/h2
    implementation("com.h2database:h2:2.3.232")
// https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core
    implementation("org.hibernate.orm:hibernate-core:6.6.1.Final")
// https://mvnrepository.com/artifact/org.flywaydb/flyway-core
    implementation("org.flywaydb:flyway-core:9.3.1")
    implementation("org.postgresql:postgresql:42.5.0")
    implementation ("org.hibernate.validator:hibernate-validator:6.2.0.Final") // or the latest version
    implementation ("jakarta.validation:jakarta.validation-api:2.0.1") // or the latest version





}

tasks.test {
    useJUnitPlatform()
}