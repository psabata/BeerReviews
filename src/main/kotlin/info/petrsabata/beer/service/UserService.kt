package info.petrsabata.beer.service

import info.petrsabata.beer.model.User
import info.petrsabata.beer.model.UserDto

interface UserService {

    fun getUsers(): List<User>

    fun getUsersDto(): List<UserDto>

    fun saveOrUpdate(review: User.Review): User

}