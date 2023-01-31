package com.example.examensegundaevaluacion.dialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.examensegundaevaluacion.R
import com.example.examensegundaevaluacion.model.Vuelo
import com.google.android.material.snackbar.Snackbar

class AdaptadorVuelo(var contexto: Context, var listaVuelos: ArrayList<Vuelo>): RecyclerView.Adapter<AdaptadorVuelo.MyHolder>() {

    inner class MyHolder(vistaItem: View): RecyclerView.ViewHolder(vistaItem){
        lateinit var textoRecycler: TextView
        lateinit var imagenOrigen: ImageView
        lateinit var imagenDestino: ImageView
        lateinit var botonDetalle: Button
        init {
            textoRecycler = vistaItem.findViewById(R.id.texto_item_recycler)
            imagenOrigen = vistaItem.findViewById(R.id.imagen_recycler_origen)
            imagenDestino = vistaItem.findViewById(R.id.imagen_recycler_destino)
            botonDetalle = vistaItem.findViewById(R.id.boton_detalles)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var vuelo = listaVuelos[position] as Vuelo
        holder.textoRecycler.setText("${vuelo.nombre}-${vuelo.nombre}")
        holder.imagenOrigen.setImageResource(vuelo.imagen)
        holder.imagenDestino.setImageResource(vuelo.imagen)
        holder.botonDetalle.setOnClickListener {
            Toast.makeText(contexto,"No se hacerlo",Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return listaVuelos.size
    }

}