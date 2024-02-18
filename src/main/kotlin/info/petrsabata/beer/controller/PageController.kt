package info.petrsabata.beer.controller

import info.petrsabata.beer.service.BeerService
import info.petrsabata.beer.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PageController(
    @Autowired private val beerService: BeerService,
    @Autowired private val userService: UserService,
) {

    @GetMapping("/")
    fun landingPage(model: Model): String {
        model.addAttribute("beers", beerService.getBeers())
        model.addAttribute("users", userService.getUsersDto())
        return "index"
    }

}