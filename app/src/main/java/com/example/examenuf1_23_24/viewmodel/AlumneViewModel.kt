package com.example.examenuf1_23_24.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.examenuf1_23_24.model.Alumne
import com.example.examenuf1_23_24.repositori.Repositori

class AlumneViewModel : ViewModel() {
    //Insert alumn
    fun newAlumn(context: Context, name:String, group: String, mark: Int) {

        var alumne = Alumne(name, group, mark)
        Repositori.insertAlumn(context,alumne)
    }
}