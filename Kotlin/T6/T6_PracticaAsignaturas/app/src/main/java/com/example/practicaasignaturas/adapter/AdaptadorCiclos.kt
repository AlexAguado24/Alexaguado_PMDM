package com.example.practicaasignaturas.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.practicaasignaturas.R
import com.example.practicaasignaturas.model.Ciclo

class AdaptadorCiclos(var contexto: Context, var listaCiclos: ArrayList<Ciclo>):BaseAdapter() {
    override fun getCount(): Int {
        return listaCiclos.size
    }

    override fun getItem(position: Int): Ciclo {
        return listaCiclos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val ciclo = listaCiclos[position]
        ciclo.imagen

        var vista = LayoutInflater.from(contexto).inflate(R.layout.spinner_item,parent,false)

        var textoCiclo:TextView = vista.findViewById(R.id.texto_spinner)
        var imagenCiclo: ImageView = vista.findViewById(R.id.imagen_spinner)

        textoCiclo.setText(ciclo.nombre)
        imagenCiclo.setImageResource(ciclo.imagen)

        return vista
    }
}