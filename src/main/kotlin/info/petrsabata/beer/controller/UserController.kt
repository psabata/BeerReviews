package info.petrsabata.beer.controller

import info.petrsabata.beer.model.User
import info.petrsabata.beer.service.UserService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(
    @Autowired private val userService: UserService,
) {

    @GetMapping("/users")
    fun users(): List<User> {
        return userService.getUsers()
    }

    @PostMapping("/review")
    fun review(@RequestBody review: User.Review): User {
        return userService.saveOrUpdate(review)
    }

    @PostMapping("/review", consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun reviewForm(review: User.Review, response: HttpServletResponse) {
        userService.saveOrUpdate(review)
        response.sendRedirect("/")
    }

}