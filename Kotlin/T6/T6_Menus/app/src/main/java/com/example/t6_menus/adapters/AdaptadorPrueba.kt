package com.example.t6_menus.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t6_menus.R

class AdaptadorPrueba(var contexto: Context, var lista: ArrayList<String>) :
    RecyclerView.Adapter<AdaptadorPrueba.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View =
            LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var nombre: String  = lista[position]
        holder.texto.text = nombre
    }

    override fun getItemCount(): Int {
        return lista.size;
    }

    fun addAsignatura(asignatura: String){

    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var texto: TextView

        init {
            texto = itemView.findViewById(R.id.texto_prueba)
        }
    }


}