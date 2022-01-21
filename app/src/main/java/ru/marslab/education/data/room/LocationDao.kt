package ru.marslab.education.data.room

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Observable
import ru.marslab.education.data.model.database.LocationDto

@Dao
interface LocationDao {

    @Query("SELECT * FROM locations")
    fun getAllLocations(): Observable<LocationDto>
}
