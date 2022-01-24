package ru.marslab.education.data.room

import android.database.Observable
import androidx.room.Dao
import androidx.room.Query
import ru.marslab.education.data.model.database.LocationDto

@Dao
interface LocationDao {

    @Query("SELECT * FROM locations")
    fun getAllLocations(): Observable<LocationDto>
}
