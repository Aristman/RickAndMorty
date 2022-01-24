package ru.marslab.education.data.room

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Observable
import ru.marslab.education.data.model.database.EpisodeDto

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM episodes")
    fun getAllEpisodes(): Observable<EpisodeDto>
}
