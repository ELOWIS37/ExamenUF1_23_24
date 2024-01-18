package com.example.examenuf1_23_24.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.examenuf1_23_24.R
import com.example.examenuf1_23_24.databinding.FragmentAlumneBinding
import com.example.examenuf1_23_24.databinding.FragmentGrupBinding

class GrupFragment : Fragment() {

    private lateinit var binding: FragmentGrupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_grup, container, false
        )

        return binding.root
    }
}