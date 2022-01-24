package ru.marslab.education.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: Gender,
    val origin: CharLocation,
    val location: CharLocation,
    val image: String,
    val episodes: List<String>,
    val url: String,
    val created: String
) {
    enum class Status {
        Alive,
        Dead,
        Unknown
    }

    enum class Gender {
        Female,
        Male,
        Genderless,
        Unknown
    }

    data class CharLocation(
        val name: String,
        val url: String
    )
}
