package com.example.examenuf1_23_24.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examenuf1_23_24.model.Alumne
import com.example.examenuf1_23_24.repositori.Repositori

class GrupViewModel : ViewModel() {

    private val _selectedItem = MutableLiveData<Alumne>()

    //Seleccionar item de la base de dades (Toast)
    fun setSelectedItem(item: Alumne) {
        _selectedItem.value = item
    }

    //Select alumn
    fun obtenirAlumnes(context: Context) : LiveData<List<Alumne>>? {
        return Repositori.getAlumnes(context)
    }

    //Select alumnes aprovats
    fun obtenirAlumnesAprovats(context: Context) : LiveData<List<Alumne>>? {
        return Repositori.getAlumnesAprovats(context)
    }

    //Select alumnes suspesos
    fun obtenirAlumnesSuspesos(context: Context) : LiveData<List<Alumne>>? {
        return Repositori.getAlumnesSuspesos(context)
    }
}