package com.example.examenuf1_23_24.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Alumn")
data class Alumne(

    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "group")
    var group: String,
    @ColumnInfo(name = "mark")
    var mark: Int
) {
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null
}
