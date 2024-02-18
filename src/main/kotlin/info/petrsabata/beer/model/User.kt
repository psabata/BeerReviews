package info.petrsabata.beer.model

data class User(
        val id: Int,
        val name: String,
        val reviews: List<Review>
) {
    data class Review(
            val beerId: Int,
            val rating: Int,
            val comment: String
    )
}