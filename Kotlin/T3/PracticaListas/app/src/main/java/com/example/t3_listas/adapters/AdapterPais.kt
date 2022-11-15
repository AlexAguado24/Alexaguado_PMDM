package com.example.t3_listas.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.t3_listas.R
import com.example.t3_listas.model.Pais

class AdapterPais (private var lista: ArrayList<Pais>, private var context: Context): BaseAdapter(){



    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Pais {
        return lista.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view:View = LayoutInflater.from(context).inflate(R.layout.item_lista, p2,false)

        //recupero el objeto con el que tengo que trabajar
        var pais:Pais = lista.get(p0)
        //recuperar los elementos graficos donde poner las cosas
        var textoNombre: TextView = view.findViewById(R.id.nombre_fila)
        var estrellaNombre: TextView = view.findViewById(R.id.estrella_fila)
        var escudoImagen: TextView = view.findViewById(R.id.imagen_lista)

        textoNombre.setText(pais.nombre)
        estrellaNombre.setText(pais.estrella)
        escudoImagen.setText(pais.imagen)


        return view
    }
}