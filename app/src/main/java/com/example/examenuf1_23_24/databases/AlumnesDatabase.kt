package com.example.examenuf1_23_24.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examenuf1_23_24.model.Alumne

@Database(
    entities = [Alumne::class],
    version = 1,
    exportSchema = false
)

abstract class AlumnesDatabase  : RoomDatabase(){
    abstract fun alumneDao() : AlumneDao

    companion object {

        @Volatile
        private var INSTANCE: AlumnesDatabase? = null

        fun getDatabase(context: Context): AlumnesDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): AlumnesDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AlumnesDatabase::class.java,
                "alumn_database"
            )
                .build()
        }
    }
}