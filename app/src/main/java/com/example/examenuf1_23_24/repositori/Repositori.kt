package com.example.examenuf1_23_24.repositori

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.examenuf1_23_24.databases.AlumnesDatabase
import com.example.examenuf1_23_24.model.Alumne
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repositori {

    companion object {

        var alumnesDatabase: AlumnesDatabase? = null
        var alumne: LiveData<List<Alumne>>? = null

        fun initializeDB(context: Context): AlumnesDatabase {
            return AlumnesDatabase.getDatabase(context)
        }

        //INSERT alumn
        fun insertAlumn(context: Context, alumne: Alumne) {

            alumnesDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                alumnesDatabase!!.alumneDao().addAlumne(alumne)
            }
        }

        //SELECT * alumn
        fun getAlumnes(context: Context): LiveData<List<Alumne>>? {

            alumnesDatabase = initializeDB(context)

            alumne = alumnesDatabase!!.alumneDao().getAlumnes()

            return alumne
        }

        //SELECT alumnes aprovats
        fun getAlumnesAprovats(context: Context): LiveData<List<Alumne>>? {

            alumnesDatabase = initializeDB(context)

            alumne = alumnesDatabase!!.alumneDao().getAlumnesAprovats()

            return alumne
        }

        //SELECT alumnes suspesos
        fun getAlumnesSuspesos(context: Context): LiveData<List<Alumne>>? {

            alumnesDatabase = initializeDB(context)

            alumne = alumnesDatabase!!.alumneDao().getAlumnesSuspesos()

            return alumne
        }
    }
}