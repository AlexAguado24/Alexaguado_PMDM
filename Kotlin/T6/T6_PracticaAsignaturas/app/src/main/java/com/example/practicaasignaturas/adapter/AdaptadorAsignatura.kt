package com.example.practicaasignaturas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaasignaturas.R
import com.example.practicaasignaturas.model.Asignatura

class AdaptadorAsignatura(var contexto: Context, var lista: ArrayList<Asignatura>) :
    RecyclerView.Adapter<AdaptadorAsignatura.MyHolder>() {

    inner class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var textoNombre:TextView;
        init {
            textoNombre = view.findViewById(R.id.texto_recycler_nombre)
        }
    }

    fun addAsignatura(asignatura: Asignatura){
        lista.add(asignatura)
        notifyItemInserted(lista.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var asignatura = lista[position] as Asignatura
        holder.textoNombre.text = asignatura.nombre
    }

    override fun getItemCount(): Int {
        return lista.size
    }


}