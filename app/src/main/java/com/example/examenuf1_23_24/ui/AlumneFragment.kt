package com.example.examenuf1_23_24.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.examenuf1_23_24.R
import com.example.examenuf1_23_24.databinding.FragmentAlumneBinding
import com.example.examenuf1_23_24.viewmodel.AlumneViewModel

class AlumneFragment : Fragment() {

    private lateinit var binding: FragmentAlumneBinding
    private lateinit var alumneViewModel: AlumneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_alumne, container, false
        )

        //Inizialitzar viewModel
        alumneViewModel = ViewModelProvider(this).get(AlumneViewModel::class.java)

        binding.insertButton.setOnClickListener {

            val nom = binding.nameEditText.text.toString()
            val grup = binding.groupEditText.text.toString()
            val nota = binding.markEditText.text.toString().trim()

            // Condició per que no peti l'aplicaió si els valors son nulls
            if (nom.isEmpty() || grup.isEmpty() || nota.isEmpty()) {
                Toast.makeText(requireContext(), "Sisplau, completi tots els camps", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Pasem els valors de la funció al viewModel
            alumneViewModel.newAlumn(requireContext(), nom, grup, nota.toInt())
            Toast.makeText(requireContext(), "Alumne afegit correctament", Toast.LENGTH_SHORT).show()

            // Reiniciar el text dels editTexts
            binding.nameEditText.setText("")
            binding.groupEditText.setText("")
            binding.markEditText.setText("")
        }

        return binding.root
    }
}