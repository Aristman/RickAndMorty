package ru.marslab.education.data.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationDto(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "dimension")
    val dimension: String,
    @ColumnInfo(name = "residents")
    val residents: String,
    @ColumnInfo(name = "created")
    val created: String,
    @ColumnInfo(name = "url")
    val url: String
)
