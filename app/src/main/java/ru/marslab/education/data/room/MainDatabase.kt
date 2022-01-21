package ru.marslab.education.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.marslab.education.data.model.database.CharacterDto
import ru.marslab.education.data.model.database.EpisodeDto
import ru.marslab.education.data.model.database.LocationDto

@Database(
    entities = [CharacterDto::class, LocationDto::class, EpisodeDto::class],
    version = 1,
    exportSchema = true
)
abstract class MainDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
}
