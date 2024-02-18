package info.petrsabata.beer.repository

import info.petrsabata.beer.model.Beer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BeerRepository : MongoRepository<Beer, Int>