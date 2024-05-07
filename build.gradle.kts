plugins {
    base
    id("com.github.imflog.kafka-schema-registry-gradle-plugin") version "2.1.0"
}

schemaRegistry {
    url = "http://localhost:8087/"
    outputDirectory = "build/schemas"
    pretty = true

    download {
        // See schema-registry.http to first register this schema with your local Schema Registry
        subject(inputSubject = "demo-schema", outputPath = "build/schemas")
    }
}

tasks {

    named("downloadSchemasTask") {
        outputs.dir("build/schemas")
    }
}
