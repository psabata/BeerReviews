package info.petrsabata.beer.service

import info.petrsabata.beer.model.Beer

interface BeerService {

    fun getBeers(): List<Beer>

}