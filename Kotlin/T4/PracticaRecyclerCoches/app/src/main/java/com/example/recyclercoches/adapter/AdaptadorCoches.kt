package com.example.recyclercoches.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclercoches.R
import com.example.recyclercoches.model.Coche

class AdaptadorCoches (var lista: ArrayList<Coche>, var contexto: Context)
    : RecyclerView.Adapter<AdaptadorCoches.MyHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var cocheActual: Coche = lista.get(position);
        holder.imagenCoche.setImageResource(cocheActual.imagen)
        holder.nombreCoche.setText(cocheActual.marca)
        holder.modeloCoche.setText(cocheActual.modelo)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var imagenCoche: ImageView
        lateinit var nombreCoche: TextView
        lateinit var modeloCoche: TextView

        init {
            imagenCoche = itemView.findViewById(R.id.imagen_coche)
            nombreCoche = itemView.findViewById(R.id.texto_nombre)
            modeloCoche = itemView.findViewById(R.id.texto_modelo)
        }
    }
}