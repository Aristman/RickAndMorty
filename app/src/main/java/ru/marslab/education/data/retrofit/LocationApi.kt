package ru.marslab.education.data.retrofit

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.marslab.education.data.model.network.LocationNW
import ru.marslab.education.data.model.network.LocationsListNW

interface LocationApi {
    @GET("location")
    fun getAllLocations(): Single<LocationsListNW>

    @GET("location/{id}")
    fun getLocationById(id: Int): Single<LocationNW>

    @GET("location/{ids}")
    fun getLocations(ids: List<Int>): Single<List<LocationNW>>

    @GET("location")
    fun getFilterLocations(
        @Query("name") name: String?,
        @Query("type") type: String?,
        @Query("dimension") dimension: String?,
    ): Single<LocationsListNW>
}
