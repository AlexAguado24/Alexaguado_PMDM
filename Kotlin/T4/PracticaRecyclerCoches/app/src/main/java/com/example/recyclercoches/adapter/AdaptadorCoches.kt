package com.example.recyclercoches.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        holder.nombreCoche.text = cocheActual.marca
        holder.botonItem.setOnClickListener {
            var intent: Intent
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imagenCoche: ImageView
        var nombreCoche: TextView
        var botonItem: Button

        init {
            imagenCoche = itemView.findViewById(R.id.imagen_coche)
            nombreCoche = itemView.findViewById(R.id.item_modelo)
            botonItem = itemView.findViewById(R.id.item_boton)
        }
    }
}