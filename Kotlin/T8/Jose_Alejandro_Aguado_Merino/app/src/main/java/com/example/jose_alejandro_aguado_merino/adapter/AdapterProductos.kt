package com.example.jose_alejandro_aguado_merino.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jose_alejandro_aguado_merino.R
import com.example.jose_alejandro_aguado_merino.model.Producto
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.core.Context

class AdapterProductos(var listaProductos: ArrayList<Producto>): RecyclerView.Adapter<AdapterProductos.MyHolder>() {

    inner class MyHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        lateinit var imagen:ImageView
        lateinit var nombre:TextView
        lateinit var itemRecycler:ConstraintLayout
        init {
            imagen = itemView.findViewById(R.id.imagen_item)
            nombre = itemView.findViewById(R.id.nombre_item)
            itemRecycler = itemView.findViewById(R.id.recycler_item_id)
        }
    }

    fun addProducto(producto:Producto){
        listaProductos.add(producto)
        notifyItemInserted(listaProductos.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var producto = listaProductos[position]
        holder.imagen.setImageResource(producto.imagen!!.toInt())
        holder.nombre.setText(producto.nombre)
        holder.itemRecycler.setOnClickListener {
            Snackbar.make(holder.itemView,producto.price!!,Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

}