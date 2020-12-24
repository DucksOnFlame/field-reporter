package eu.ducksoft.taskservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["eu.ducksoft"])
class FieldReporterApplication

fun main(args: Array<String>) {
    runApplication<FieldReporterApplication>(*args)
}
