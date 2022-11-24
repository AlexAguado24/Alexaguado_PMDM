package com.example.hobbies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.view.get
import com.example.hobbies.adapters.AdapterFutbol
import com.example.hobbies.adapters.AdapterSeries
import com.example.hobbies.databinding.ActivityMainBinding
import com.example.hobbies.databinding.ActivitySecondBinding
import com.example.hobbies.models.Futbol
import com.example.hobbies.models.Serie

class SecondActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivitySecondBinding
    lateinit var arrayFutbol: ArrayList<Futbol>
    lateinit var arraySeries: ArrayList<Serie>
    lateinit var spinnerSencillo: ArrayAdapter<CharSequence>
    lateinit var adaptadorFutbol: AdapterFutbol
    lateinit var adaptadorSeries: AdapterSeries

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos()
        acciones()
    }

    private fun acciones() {
        binding.spinnerHobbies.onItemSelectedListener = this
    }

    private fun asociarDatos() {
        //asocio el spinner con el adaptador que he creado
        binding.spinnerHobbies.adapter = spinnerSencillo
        //binding.listaHobbies.adapter = adaptadorSeries
        binding.listaHobbies.adapter = adaptadorFutbol
    }

    private fun instancias() {
        //Relleno el array de futbol y se le doy al adaptador
        arrayFutbol = ArrayList()
        arrayFutbol.add(Futbol(R.drawable.maradona,"Maradona","Argentina"))
        arrayFutbol.add(Futbol(R.drawable.messi,"Messi","FC Barcelona"))
        arrayFutbol.add(Futbol(R.drawable.ronaldo,"Ronaldo","Brasil"))
        arrayFutbol.add(Futbol(R.drawable.zidane,"Zidane","Francia"))
        adaptadorFutbol = AdapterFutbol(arrayFutbol,applicationContext)

        //Relleno el array de series y se le doy al adaptador
        arraySeries = ArrayList()
        arraySeries.add(Serie(R.drawable.lost,"Perdidos","Misterio"))
        arraySeries.add(Serie(R.drawable.papel,"La casa de papel","Accion"))
        arraySeries.add(Serie(R.drawable.tronos,"GOT","Fantasia"))
        arraySeries.add(Serie(R.drawable.stranger,"Stranger Things","Ciencia Ficcion"))
        adaptadorSeries = AdapterSeries(arraySeries,applicationContext)
        //le doy al spinner los valores del string-array
        spinnerSencillo = ArrayAdapter.createFromResource(
            applicationContext,
            R.array.hobbies,
            android.R.layout.simple_list_item_1
        )
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p0!!.id) {
            R.id.spinner_hobbies -> {
                if (binding.spinnerHobbies.get(p2).toString() == "Futbol") {
                    binding.listaHobbies.adapter = adaptadorFutbol
                    arrayFutbol = ArrayList()
                    arrayFutbol.add(Futbol(R.drawable.maradona,"Maradona","Argentina"))
                    arrayFutbol.add(Futbol(R.drawable.messi,"Messi","FC Barcelona"))
                    arrayFutbol.add(Futbol(R.drawable.ronaldo,"Ronaldo","Brasil"))
                    arrayFutbol.add(Futbol(R.drawable.zidane,"Zidane","Francia"))
                    adaptadorFutbol = AdapterFutbol(arrayFutbol,applicationContext)
                    adaptadorFutbol.notifyDataSetChanged()
                } else if (binding.spinnerHobbies.get(p2).toString() == "Juegos") {

                } else if (binding.spinnerHobbies.get(p2).toString() == "Series") {
                    arraySeries = ArrayList()
                    arraySeries.add(Serie(R.drawable.lost,"Perdidos","Misterio"))
                    arraySeries.add(Serie(R.drawable.papel,"La casa de papel","Accion"))
                    arraySeries.add(Serie(R.drawable.tronos,"GOT","Fantasia"))
                    arraySeries.add(Serie(R.drawable.stranger,"Stranger Things","Ciencia Ficcion"))
                    adaptadorSeries = AdapterSeries(arraySeries,applicationContext)
                    adaptadorSeries.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}