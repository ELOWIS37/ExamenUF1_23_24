package com.example.examenuf1_23_24.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenuf1_23_24.R
import com.example.examenuf1_23_24.adapter.AlumneAdapter
import com.example.examenuf1_23_24.databinding.FragmentAlumneBinding
import com.example.examenuf1_23_24.databinding.FragmentGrupBinding
import com.example.examenuf1_23_24.viewmodel.GrupViewModel

class GrupFragment : Fragment() {

    private lateinit var binding: FragmentGrupBinding
    private lateinit var grupViewModel: GrupViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_grup, container, false
        )

        grupViewModel = ViewModelProvider(this).get(GrupViewModel::class.java)

        viewManager = LinearLayoutManager(context)

        recyclerView = binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }

        selectAlumnesToRecyclerView()

        binding.switchAprovats.setOnClickListener{ selectAlumnesToRecyclerView() }
        binding.switchSuspesos.setOnClickListener{ selectAlumnesToRecyclerView() }

        return binding.root
    }

    fun selectAlumnesToRecyclerView(){

        val aprovats = binding.switchAprovats.isChecked
        val suspesos = binding.switchSuspesos.isChecked

        if (aprovats && suspesos){
            grupViewModel.obtenirAlumnes(requireContext())?.observe(viewLifecycleOwner, Observer { alumnesLlista ->
                alumnesLlista?.let {
                    viewAdapter = AlumneAdapter(it) { item ->
                        grupViewModel.setSelectedItem(item)
                        Toast.makeText(requireContext(), "$item", Toast.LENGTH_SHORT).show()
                    }
                    recyclerView.adapter = viewAdapter
                }
            })
        }
        else if (aprovats){
            grupViewModel.obtenirAlumnesAprovats(requireContext())?.observe(viewLifecycleOwner, Observer { alumnesLlista ->
                alumnesLlista?.let {
                    viewAdapter = AlumneAdapter(it) { item ->
                        grupViewModel.setSelectedItem(item)
                        Toast.makeText(requireContext(), "$item", Toast.LENGTH_SHORT).show()
                    }
                    recyclerView.adapter = viewAdapter
                }
            })
        }
        else if (suspesos) {
            grupViewModel.obtenirAlumnesSuspesos(requireContext())?.observe(viewLifecycleOwner, Observer { alumnesLlista ->
                alumnesLlista?.let {
                    viewAdapter = AlumneAdapter(it) { item ->
                        grupViewModel.setSelectedItem(item)
                        Toast.makeText(requireContext(), "$item", Toast.LENGTH_SHORT).show()
                    }
                    recyclerView.adapter = viewAdapter
                }
            })
        } else {

            Toast.makeText(requireContext(), "Has de seleccionar APROVATS O SUSPESOS", Toast.LENGTH_SHORT).show()
        }
    }
}