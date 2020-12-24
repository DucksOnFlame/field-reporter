package eu.ducksoft.serviceregister

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["eu.ducksoft"])
class TaskServiceApplication

fun main(args: Array<String>) {
	runApplication<TaskServiceApplication>(*args)
}
