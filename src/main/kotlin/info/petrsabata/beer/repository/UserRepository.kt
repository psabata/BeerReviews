package info.petrsabata.beer.repository

import info.petrsabata.beer.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User, Int>