package com.example.jose_alejandro_aguado_merino.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.jose_alejandro_aguado_merino.R
import com.example.jose_alejandro_aguado_merino.modelo.Coche

class AdaptadorModelos(var lista: ArrayList<Coche>, var context: Context): BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Any {
        return lista.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(context).inflate(R.layout.item_modelo,parent,false)
        var coche:Coche = lista.get(position);
        var imagenModelo: ImageView = view.findViewById(R.id.imagen_modelo)
        var nombreModelo: TextView = view.findViewById(R.id.nombre_modelo)
        var textoModelo: TextView = view.findViewById(R.id.texto_modelo)

        imagenModelo.setImageResource(coche.imagen)
        nombreModelo.setText(coche.nombre)
        textoModelo.setText(coche.marca)

        return view;
    }
}