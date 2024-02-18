package info.petrsabata.beer.service.impl

import info.petrsabata.beer.model.Beer
import info.petrsabata.beer.repository.BeerRepository
import info.petrsabata.beer.repository.UserRepository
import info.petrsabata.beer.service.StartupService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service

@Service

class StartupServiceImpl(
        @Autowired private val restTemplateBuilder: RestTemplateBuilder,
        @Autowired private val beerRepository: BeerRepository,
        @Autowired private val userRepository: UserRepository,
) : StartupService {

    companion object {
        private const val URL = "https://random-data-api.com/api/v2/beers?size=5"
    }

    private val restTemplate = restTemplateBuilder.build()
    private val logger: Logger = LoggerFactory.getLogger(StartupServiceImpl::class.java)

    override fun initResourcesOnStartup() {
        initBeers()
        initUsers()
    }

    private fun initBeers() {
        val beers = try {
            (restTemplate.getForObject(URL, Array<Beer>::class.java)?.asList() ?: emptyList()).also {
                logger.info("Resources downloaded: $it")
            }
        } catch (exception: Exception) {
            logger.error("Error downloading resources: $exception")
            emptyList()
        }

        beerRepository.deleteAll()
        beerRepository.saveAll(beers)
    }

    private fun initUsers() {
        userRepository.deleteAll()
    }

}