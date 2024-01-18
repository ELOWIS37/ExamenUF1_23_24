package com.example.examenuf1_23_24.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examenuf1_23_24.model.Alumne
import com.example.examenuf1_23_24.repositori.Repositori

class GrupViewModel : ViewModel() {

    private val _selectedItem = MutableLiveData<Alumne>()

    //Select alumn
    fun obtenirAlumnes(context: Context) : LiveData<List<Alumne>>? {
        return Repositori.getAlumnes(context)
    }

    //Seleccionar item de la base de dades
    fun setSelectedItem(item: Alumne) {
        _selectedItem.value = item
    }
}