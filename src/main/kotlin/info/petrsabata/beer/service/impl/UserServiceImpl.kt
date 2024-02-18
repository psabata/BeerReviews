package info.petrsabata.beer.service.impl

import info.petrsabata.beer.model.User
import info.petrsabata.beer.model.UserDto
import info.petrsabata.beer.repository.BeerRepository
import info.petrsabata.beer.repository.UserRepository
import info.petrsabata.beer.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val beerRepository: BeerRepository,
) : UserService {

    override fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    override fun getUsersDto(): List<UserDto> {
        val beers = beerRepository.findAll()

        return userRepository.findAll().map { user ->
            UserDto(
                id = user.id,
                name = user.name,
                reviews = user.reviews.map { review ->
                    UserDto.ReviewDto(
                        beerId = review.beerId,
                        beerName = beers.first { it.id == review.beerId }.name,
                        rating = review.rating,
                        comment = review.comment,
                    )
                },
            )
        }
    }

    override fun saveOrUpdate(review: User.Review): User {
        val user = userRepository.findByIdOrNull(1) ?: User(1, "default", emptyList())
        val updatedReviews = updateOrAppend(user.reviews, review)

        return User(
            id = user.id,
            name = user.name,
            reviews = updatedReviews
        ).also {
            userRepository.save(it)
        }
    }

    private fun updateOrAppend(reviews: List<User.Review>, review: User.Review): MutableList<User.Review> {
        return reviews.toMutableList().apply {
            indexOfFirst { it.beerId == review.beerId }.also { index ->
                if (index < 0) {
                    add(review)
                } else {
                    set(index, review)
                }
            }
        }
    }

}