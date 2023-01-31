package com.example.examensegundaevaluacion.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.examensegundaevaluacion.R
import com.example.examensegundaevaluacion.model.Vuelo

class AdaptadorSpinner(var contexto:Context, var lista:ArrayList<Vuelo>): BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Vuelo {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = LayoutInflater.from(contexto).inflate(R.layout.item_spinner,parent,false);

        var vuelo = lista[position]

        var imagenSpinner: ImageView = vista.findViewById(R.id.imagen_spinner)
        var nombreSpinner: TextView = vista.findViewById(R.id.texto_spinner)

        imagenSpinner.setImageResource(vuelo.imagen)
        nombreSpinner.setText(vuelo.nombre)


        return vista
    }
}