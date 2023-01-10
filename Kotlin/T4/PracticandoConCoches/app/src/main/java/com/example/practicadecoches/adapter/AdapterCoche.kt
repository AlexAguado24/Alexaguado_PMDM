package com.example.practicadecoches.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicadecoches.R
import com.example.practicadecoches.model.Coche

class AdapterCoche(var contexto: Context, var lista: ArrayList<Coche>): RecyclerView.Adapter<AdapterCoche.Myholder>() {


    inner class Myholder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imagen : ImageView
        var textoNombre: TextView
        var boton: Button

        init {
            imagen = itemView.findViewById(R.id.imagen_item)
            textoNombre = itemView.findViewById(R.id.modelo_item)
            boton = itemView.findViewById(R.id.boton_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myholder {
        val view: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return Myholder(view)
    }

    override fun onBindViewHolder(holder: Myholder, position: Int) {
        val coche = lista.get(position);
        holder.textoNombre.text = coche.modelo
        holder.imagen.setImageResource(coche.imagen)
        holder.boton.setOnClickListener {

        //comunicacion



        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}