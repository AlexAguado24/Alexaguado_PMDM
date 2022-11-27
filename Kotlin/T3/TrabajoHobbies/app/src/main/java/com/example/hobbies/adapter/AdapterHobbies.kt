package com.example.hobbies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.hobbies.R
import com.example.hobbies.model.HobbieLista

class AdapterHobbies (var lista: ArrayList<HobbieLista>, var context: Context) : BaseAdapter(){

    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Any {
        return lista.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var vista: View = LayoutInflater.from(context).inflate(R.layout.item_lista,p2,false)

        var hobbie = lista.get(p0)
        var imagenLista : ImageView = vista.findViewById(R.id.imagen_lista)
        var nombreLista : TextView = vista.findViewById(R.id.nombre_lista)
        var generoLista : TextView = vista.findViewById(R.id.genero_lista)

        imagenLista.setImageResource(hobbie.imagen)
        nombreLista.text = hobbie.nombre
        generoLista.text = hobbie.genero

        return vista
    }
}