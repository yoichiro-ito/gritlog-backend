package app.gritlog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GritlogBackendApplication

fun main(args: Array<String>) {
    runApplication<GritlogBackendApplication>(*args)
}
