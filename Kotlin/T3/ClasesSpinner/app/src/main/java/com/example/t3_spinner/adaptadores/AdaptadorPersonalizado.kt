package com.example.t3_spinner.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.t3_spinner.R
import com.example.t3_spinner.modelo.Pais

class AdaptadorPersonalizado(var listaElementos: ArrayList<Pais>, var context: Context) : BaseAdapter(){



    override fun getCount(): Int {
        //retornar el numero de elementos que el spinner tiene que pintar
        return listaElementos.size
    }

    override fun getItem(p0: Int): Any {
        //retorna el elemento que esta en una posicion indicada como parametro
        return listaElementos.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        //retorno el long asociado a un elemento que esta en una posicion indicada como parametro
        return p0.toLong()
    }

    fun agregarPais(pais: Pais){
        listaElementos.add(pais)
        notifyDataSetChanged()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //retorna la vista (fila) ya rellena con los datos que estan en una posicion indicada --> p0
        //para poder rellenar la fila ya rellena -> xml

        var vista: View = LayoutInflater.from(context).inflate(R.layout.item_spinner,p2,false)

        var nombre: TextView = vista.findViewById(R.id.texto_fila);
        var imagen: ImageView = vista.findViewById(R.id.imagen_fila);

        var elemento = listaElementos.get(p0)
        nombre.text = elemento.nombre
        imagen.setImageResource(elemento.imagen)

        return vista;
    }
}