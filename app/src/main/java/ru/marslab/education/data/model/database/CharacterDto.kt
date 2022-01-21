package ru.marslab.education.data.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterDto(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "episodes")
    val episodes: String,
    @ColumnInfo(name = "species")
    val species: String,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "location")
    val location: String,
    @ColumnInfo(name = "origin")
    val origin: String,
    @ColumnInfo(name = "created")
    val created: String,
    @ColumnInfo(name = "url")
    val url: String
)
