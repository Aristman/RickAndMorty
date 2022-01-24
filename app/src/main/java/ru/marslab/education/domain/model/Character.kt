package ru.marslab.education.domain.model

data class Character(
    val id: Int = 0,
    val name: String = "",
    val status: Status = Status.Alive,
    val species: String = "",
    val type: String = "",
    val gender: Gender = Gender.Male,
    val origin: CharLocation = CharLocation(),
    val location: CharLocation = CharLocation(),
    val image: String = "",
    val episodes: List<String> = emptyList(),
    val url: String = "",
    val created: String = ""
) {
    enum class Status {
        Alive,
        Dead,
        unknown
    }

    enum class Gender {
        Female,
        Male,
        Genderless,
        unknown
    }

    data class CharLocation(
        val name: String = "",
        val url: String = ""
    )
}
