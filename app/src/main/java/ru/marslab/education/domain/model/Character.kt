package ru.marslab.education.domain.model

data class Character(
    val id: Int = 0,
    val name: String = "",
    val status: Status = Status.alive,
    val species: String = "",
    val type: String = "",
    val gender: Gender = Gender.male,
    val origin: CharLocation = CharLocation(),
    val location: CharLocation = CharLocation(),
    val image: String = "",
    val episodes: List<String> = emptyList(),
    val url: String = "",
    val created: String = ""
) {
    enum class Status {
        alive,
        dead,
        unknown
    }

    enum class Gender {
        female,
        male,
        genderless,
        unknown
    }

    data class CharLocation(
        val name: String = "",
        val url: String = ""
    )
}
