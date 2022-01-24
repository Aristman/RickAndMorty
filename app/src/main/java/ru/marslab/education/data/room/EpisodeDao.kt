package ru.marslab.education.data.room

import android.database.Observable
import androidx.room.Dao
import androidx.room.Query
import ru.marslab.education.data.model.database.EpisodeDto

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM episodes")
    fun getAllEpisodes(): Observable<EpisodeDto>
}
