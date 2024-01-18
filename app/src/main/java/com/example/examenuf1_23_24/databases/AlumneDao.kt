package com.example.examenuf1_23_24.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examenuf1_23_24.model.Alumne

@Dao
interface AlumneDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAlumne(alumne: Alumne)

    @Query("SELECT * FROM Alumn")
    fun getAlumnes(): LiveData<List<Alumne>>

    @Query("SELECT * FROM Alumn WHERE mark >= 5")
    fun getAlumnesAprovats(): LiveData<List<Alumne>>

    @Query("SELECT * FROM Alumn WHERE mark < 5")
    fun getAlumnesSuspesos(): LiveData<List<Alumne>>
}