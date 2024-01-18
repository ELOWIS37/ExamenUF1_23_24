package com.example.examenuf1_23_24.databases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.examenuf1_23_24.model.Alumne

@Dao
interface AlumneDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAlumne(alumne: Alumne)
}