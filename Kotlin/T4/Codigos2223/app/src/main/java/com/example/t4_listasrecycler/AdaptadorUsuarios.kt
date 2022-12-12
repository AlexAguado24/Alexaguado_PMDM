package com.example.t4_listasrecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdaptadorUsuarios(var lista: ArrayList<Usuario>, var contexto: Context)
    : RecyclerView.Adapter<AdaptadorUsuarios.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista: View  = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false) ;  //xml con el aspecto de cada fila
        return MyHolder(vista);
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var usuarioActual = lista.get(position);
        holder.textoNombre.setText(usuarioActual.nombre);
        holder.textoApellido.setText(usuarioActual.apellido);
        holder.imagenUsuario.setImageResource(usuarioActual.imagen);
    }

    override fun getItemCount(): Int {
        // tamaño de la lista
        return lista.size
    }

    inner class MyHolder(itemView: View) : ViewHolder(itemView) {
        var textoNombre: TextView
        var textoApellido: TextView
        var imagenUsuario: ImageView

        init {
            textoNombre = itemView.findViewById(R.id.nombre_item)
            textoApellido = itemView.findViewById(R.id.apellido_item)
            imagenUsuario = itemView.findViewById(R.id.imagen_item)
        }

    }
}