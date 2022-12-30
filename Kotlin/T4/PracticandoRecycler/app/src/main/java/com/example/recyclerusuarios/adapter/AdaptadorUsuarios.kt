package com.example.recyclerusuarios.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerusuarios.R
import com.example.recyclerusuarios.model.Usuario
import com.google.android.material.snackbar.Snackbar

class AdaptadorUsuarios(var lista: ArrayList<Usuario>, var contexto: Context) :
    RecyclerView.Adapter<AdaptadorUsuarios.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista: View =
            LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var usuarioActual = lista.get(position);
        holder.imagenVista.setImageResource(usuarioActual.imagen)
        holder.textoNombre.setText(usuarioActual.nombre)
        holder.textoApellido.setText(usuarioActual.apellido)

        holder.textoNombre.setOnClickListener { Log.v("lista", "Texto nombre pulsado") }
        holder.textoApellido.setOnClickListener { Log.v("lista", "Texto apellido pulsado") }
        holder.imagenVista.setOnClickListener {
            Snackbar.make(
                holder.itemView,
                "Imagen pulsada",
                Snackbar.LENGTH_SHORT
            ).show()
        }

    }

    override fun getItemCount(): Int {
        //tamaño de la lista
        return lista.size
    }

    inner class MyHolder(itemView: View) : ViewHolder(itemView) {
        var imagenVista: ImageView
        var textoNombre: TextView
        var textoApellido: TextView

        init {
            textoNombre = itemView.findViewById(R.id.nombre_item)
            textoApellido = itemView.findViewById(R.id.apellido_item)
            imagenVista = itemView.findViewById(R.id.imagen_item)
        }
    }
}