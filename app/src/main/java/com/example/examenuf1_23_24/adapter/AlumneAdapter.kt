package com.example.examenuf1_23_24.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenuf1_23_24.R
import com.example.examenuf1_23_24.model.Alumne

class AlumneAdapter(private val alumne: List<Alumne>, private val onItemClick: (Alumne) -> Unit) :
    RecyclerView.Adapter<AlumneAdapter.AlumneViewHolder>() {

    // ViewHolder que conté les vistes de cada element
    class AlumneViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nom: TextView = view.findViewById(R.id.textViewName)
        val grup: TextView = view.findViewById(R.id.textViewGroup)
        val nota: TextView = view.findViewById(R.id.textViewMark)
    }

    // Crea una nova vista (invocada per el layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumneViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardview, parent, false) // importem cardview
        return AlumneViewHolder(view)
    }

    // Canvia el contingut de una vista del cardview (invocada per el layout manager)
    override fun onBindViewHolder(holder: AlumneViewHolder, position: Int) {
        val alumne = alumne[position]

        holder.itemView.setOnClickListener {
            onItemClick.invoke(alumne)
        }

        holder.nom.text = alumne.name
        holder.grup.text = alumne.group
        holder.nota.text = alumne.mark.toString()
    }

    // Retorna el tamany del conjunt de dades (invocada per el layout manager)
    override fun getItemCount() = alumne.size
}