package info.petrsabata.beer.service.impl

import info.petrsabata.beer.model.Beer
import info.petrsabata.beer.repository.BeerRepository
import info.petrsabata.beer.service.BeerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BeerServiceImpl(
    @Autowired private val beerRepository: BeerRepository,
) : BeerService {

    override fun getBeers(): List<Beer> {
        return beerRepository.findAll()
    }
}