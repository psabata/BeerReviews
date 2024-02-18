package info.petrsabata.beer.controller

import info.petrsabata.beer.model.Beer
import info.petrsabata.beer.service.BeerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class BeerController(
    @Autowired private val beerService: BeerService,
) {

    @GetMapping("/beers")
    fun beers(): List<Beer> {
        return beerService.getBeers()
    }

}