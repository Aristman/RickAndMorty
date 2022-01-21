package ru.marslab.education.domain.repository

import io.reactivex.Observable
import io.reactivex.Single
import ru.marslab.education.domain.model.Episode

interface EpisodeRepository {
    fun getAllEpisodes(): Observable<Episode>
    fun getEpisode(id: Int): Single<Episode>
    fun getEpisodes(ids: List<Int>): Observable<Episode>
    fun getFilterEpisodes(
        name: String? = null,
        type: String? = null,
        dimension: String? = null
    ): Observable<Episode>
}
