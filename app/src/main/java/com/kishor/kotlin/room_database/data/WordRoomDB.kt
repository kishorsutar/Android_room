package com.kishor.kotlin.room_database.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class WordRoomDB : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {

        @Volatile
        private var INSTANCE: WordRoomDB? = null

        fun getDataBase(context: Context): WordRoomDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDB::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}