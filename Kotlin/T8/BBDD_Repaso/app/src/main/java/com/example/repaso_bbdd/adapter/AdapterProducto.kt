package com.example.repaso_bbdd.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.repaso_bbdd.R
import com.example.repaso_bbdd.model.Producto

class AdapterProducto(var contexto:Context, var listaProductos: ArrayList<Producto>): RecyclerView.Adapter<AdapterProducto.MyHolder>() {

    inner class MyHolder(vista: View): RecyclerView.ViewHolder(vista){
        lateinit var nombre: TextView
        lateinit var valor: TextView
        init {
            nombre = vista.findViewById(R.id.text_nombre)
            valor = vista.findViewById(R.id.text_valor)
        }
    }

    fun addProducto(producto:Producto){
        listaProductos.add(producto)
        notifyItemInserted(listaProductos.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista = LayoutInflater.from(contexto).inflate(R.layout.recycler_item,parent,false);
        return MyHolder(vista);
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var producto = listaProductos[position]
        holder.nombre.setText(producto.nombre)
        holder.nombre.setText(producto.valor.toString())
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }
}