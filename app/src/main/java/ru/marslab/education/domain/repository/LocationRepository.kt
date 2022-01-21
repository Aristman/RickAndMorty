package ru.marslab.education.domain.repository

import io.reactivex.Observable
import io.reactivex.Single
import ru.marslab.education.domain.model.Location

interface LocationRepository {
    fun getAllLocations(): Observable<Location>
    fun getLocation(id: Int): Single<Location>
    fun getLocations(ids: List<Int>): Observable<Location>
    fun getFilterLocations(
        name: String? = null,
        type: String? = null,
        dimension: String? = null
    ): Observable<Location>
}
