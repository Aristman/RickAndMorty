package ru.marslab.education.data.room

import android.database.Observable
import androidx.room.Dao
import androidx.room.Query
import ru.marslab.education.data.model.database.CharacterDto

@Dao
interface CharacterDao {
    @Query("SELECT * FROM characters")
    fun getAllCharters(): Observable<CharacterDto>
}
