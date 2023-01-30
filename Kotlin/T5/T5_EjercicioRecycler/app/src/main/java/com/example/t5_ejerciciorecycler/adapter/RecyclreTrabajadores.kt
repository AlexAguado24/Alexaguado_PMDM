package com.example.t5_ejerciciorecycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t5_ejerciciorecycler.R
import com.example.t5_ejerciciorecycler.model.Usuario

class RecyclreTrabajadores(var contexto:Context, var lista: ArrayList<Usuario>): RecyclerView.Adapter<RecyclreTrabajadores.MyHolder>() {

    private lateinit var listener: OnUsuarioRecyclerSelected

    inner class MyHolder( var vista: View): RecyclerView.ViewHolder(vista){
        var linear: LinearLayout
        var nombre: TextView
        var apellido: TextView
        init {
            linear = vista.findViewById(R.id.linear_general)
            nombre = vista.findViewById(R.id.texto_nombre)
            apellido = vista.findViewById(R.id.texto_apellido)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view:View = LayoutInflater.from(contexto).inflate(R.layout.recycler_item,parent,false)
        return MyHolder(view);
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var trabajador: Usuario = lista[position];
        holder.nombre.setText(trabajador.nombre)
        holder.apellido.setText(trabajador.apellido)
        holder.linear.setOnClickListener {
            listener.onUsuarioClickListener(trabajador)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    interface OnUsuarioRecyclerSelected{
        fun onUsuarioClickListener(usuario: Usuario);
    }
}