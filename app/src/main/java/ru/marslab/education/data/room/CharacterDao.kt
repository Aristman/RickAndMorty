package ru.marslab.education.data.room

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Observable
import ru.marslab.education.data.model.database.CharacterDto

@Dao
interface CharacterDao {
    @Query("SELECT * FROM characters")
    fun getAllCharters(): Observable<CharacterDto>
}
