package ru.marslab.education.data.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "episodes")
data class EpisodeDto(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "episode")
    val episode: String,
    @ColumnInfo(name = "airDate")
    val airDate: String,
    @ColumnInfo(name = "characters")
    val characters: String,
    @ColumnInfo(name = "created")
    val created: String,
    @ColumnInfo(name = "url")
    val url: String
)
