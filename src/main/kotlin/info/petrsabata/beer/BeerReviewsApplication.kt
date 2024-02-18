package info.petrsabata.beer

import info.petrsabata.beer.service.StartupService
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BeerReviewsApplication(
    private val startupService: StartupService,
) {

    @PostConstruct
    fun init() {
        startupService.initResourcesOnStartup()
    }

}

fun main(args: Array<String>) {
    runApplication<BeerReviewsApplication>(*args)
}


