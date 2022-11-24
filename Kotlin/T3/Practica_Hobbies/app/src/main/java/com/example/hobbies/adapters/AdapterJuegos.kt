package com.example.hobbies.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.hobbies.R
import com.example.hobbies.models.Juego

class AdapterJuegos(private var lista: ArrayList<Juego>, private var context: Context): BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Juego {
        return lista.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view: View = LayoutInflater.from(context).inflate(R.layout.item_lista,p2,false);
        var juego: Juego = lista.get(p0)
        var imagenJuego: ImageView = view.findViewById(R.id.imagen_lista)
        var textoNombre: TextView = view.findViewById(R.id.texto_nombre)
        var textoGenero: TextView = view.findViewById(R.id.texto_genero)
        imagenJuego.setImageResource(juego.imagenJuego)
        textoNombre.setText(juego.nombre)
        textoGenero.setText(juego.tipo)

        return view;
    }
}