package ru.marslab.education.data.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object RoomClient {
    private const val DATABASE_NAME = "main_base.db"

    fun databaseInstance(context: Context): RoomDatabase =
        Room.databaseBuilder(
            context,
            MainDatabase::class.java,
            DATABASE_NAME
        )
            .build()
}
