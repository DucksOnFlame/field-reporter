package eu.ducksoft.taskservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FieldReporterApplication

fun main(args: Array<String>) {
    runApplication<FieldReporterApplication>(*args)
}
