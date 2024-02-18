package info.petrsabata.beer.model

data class UserDto(
    val id: Int,
    val name: String,
    val reviews: List<ReviewDto>
) {
    data class ReviewDto(
        val beerId: Int,
        val beerName: String,
        val rating: Int,
        val comment: String
    )
}