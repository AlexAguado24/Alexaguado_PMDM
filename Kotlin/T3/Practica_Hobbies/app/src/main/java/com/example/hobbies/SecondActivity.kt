package com.example.hobbies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.contains
import androidx.core.view.get
import com.example.hobbies.adapters.AdapterFutbol
import com.example.hobbies.adapters.AdapterJuegos
import com.example.hobbies.adapters.AdapterSeries
import com.example.hobbies.databinding.ActivityMainBinding
import com.example.hobbies.databinding.ActivitySecondBinding
import com.example.hobbies.models.Futbol
import com.example.hobbies.models.Juego
import com.example.hobbies.models.Serie
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivitySecondBinding
    lateinit var arrayFutbol: ArrayList<Futbol>
    lateinit var arraySeries: ArrayList<Serie>
    lateinit var arrayJuegos: ArrayList<Juego>
    lateinit var spinnerSencillo: ArrayAdapter<CharSequence>
    lateinit var adaptadorFutbol: AdapterFutbol
    lateinit var adaptadorSeries: AdapterSeries
    lateinit var adaptadorJuego: AdapterJuegos

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
        binding.listaHobbies.setOnItemClickListener { adapterView, view, i, l ->
            binding.fLayout.visibility = View.VISIBLE

            /*if (adapterView ) {
                var juegos: Juego = arrayJuegos.get(i)
                binding.imagenFrame.setImageResource(juegos.imagenJuego)
                binding.nombreFrame.setText(juegos.imagenJuego)
                binding.generoFrame.setText(juegos.tipo)
            } else if (view.equals(adaptadorFutbol)) {
                var futbol: Futbol = arrayFutbol.get(i)
                binding.imagenFrame.setImageResource(futbol.imagenFutbol)
                binding.nombreFrame.setText(futbol.nombre)
                binding.generoFrame.setText(futbol.equipo)
            } else if (view.equals(adaptadorSeries)) {
                var serie: Serie = arraySeries.get(i)
                binding.imagenFrame.setImageResource(serie.imagenSerie)
                binding.nombreFrame.setText(serie.nombre)
                binding.generoFrame.setText(serie.genero)
            }*/
        }
    }

    private fun asociarDatos() {
        //asocio el spinner con el adaptador que he creado
        binding.spinnerHobbies.adapter = spinnerSencillo
        binding.listaHobbies.adapter = adaptadorSeries
        binding.listaHobbies.adapter = adaptadorFutbol
        binding.listaHobbies.adapter = adaptadorJuego
    }

    private fun instancias() {
        //Relleno el array de futbol y se le doy al adaptador
        arrayFutbol = ArrayList()
        arrayFutbol.add(Futbol(R.drawable.maradona, "Maradona", "Argentina"))
        arrayFutbol.add(Futbol(R.drawable.messi, "Messi", "FC Barcelona"))
        arrayFutbol.add(Futbol(R.drawable.ronaldo, "Ronaldo", "Brasil"))
        arrayFutbol.add(Futbol(R.drawable.zidane, "Zidane", "Francia"))
        adaptadorFutbol = AdapterFutbol(arrayFutbol, applicationContext)

        //Relleno el array de series y se le doy al adaptador
        arraySeries = ArrayList()
        arraySeries.add(Serie(R.drawable.lost, "Perdidos", "Misterio"))
        arraySeries.add(Serie(R.drawable.papel, "La casa de papel", "Accion"))
        arraySeries.add(Serie(R.drawable.tronos, "GOT", "Fantasia"))
        arraySeries.add(Serie(R.drawable.stranger, "Stranger Things", "Ciencia Ficcion"))
        adaptadorSeries = AdapterSeries(arraySeries, applicationContext)

        //Relleno el array de juegos y se le doy al adaptador
        arrayJuegos = ArrayList()
        arrayJuegos.add(Juego(R.drawable.ffx, "F. Fantasy", "Roll"))
        arrayJuegos.add(Juego(R.drawable.god, "GOW", "Accion"))
        arrayJuegos.add(Juego(R.drawable.gt, "Gran Turismo", "Carreras"))
        arrayJuegos.add(Juego(R.drawable.metal, "Metal Gear", "Disparos"))
        adaptadorJuego = AdapterJuegos(arrayJuegos, applicationContext)
        //le doy al spinner los valores del string-array
        spinnerSencillo = ArrayAdapter.createFromResource(
            applicationContext,
            R.array.hobbies,
            android.R.layout.simple_list_item_1
        )

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        //Indico la seleccion del cambio en el spinner a traves de la posicion y lo vuelvo a rellenar
        if (p2 == 0) {
            binding.listaHobbies.adapter = adaptadorFutbol
            /*arrayFutbol = ArrayList()
            arrayFutbol.add(Futbol(R.drawable.maradona, "Maradona", "Argentina"))
            arrayFutbol.add(Futbol(R.drawable.messi, "Messi", "FC Barcelona"))
            arrayFutbol.add(Futbol(R.drawable.ronaldo, "Ronaldo", "Brasil"))
            arrayFutbol.add(Futbol(R.drawable.zidane, "Zidane", "Francia"))
            adaptadorFutbol = AdapterFutbol(arrayFutbol, applicationContext)
            adaptadorFutbol.notifyDataSetChanged()*/
        } else if (p2 == 1) {
            binding.listaHobbies.adapter = adaptadorJuego
            /*arrayJuegos = ArrayList()
            arrayJuegos.add(Juego(R.drawable.ffx, "F. Fantasy", "Roll"))
            arrayJuegos.add(Juego(R.drawable.god, "GOW", "Accion"))
            arrayJuegos.add(Juego(R.drawable.gt, "Gran Turismo", "Carreras"))
            arrayJuegos.add(Juego(R.drawable.metal, "Metal Gear", "Disparos"))
            adaptadorJuego = AdapterJuegos(arrayJuegos, applicationContext)
            adaptadorJuego.notifyDataSetChanged()*/
        } else if (p2 == 2) {
            binding.listaHobbies.adapter = adaptadorSeries
            /*arraySeries = ArrayList()
            arraySeries.add(Serie(R.drawable.lost, "Perdidos", "Misterio"))
            arraySeries.add(Serie(R.drawable.papel, "La casa de papel", "Accion"))
            arraySeries.add(Serie(R.drawable.tronos, "GOT", "Fantasia"))
            arraySeries.add(Serie(R.drawable.stranger, "Stranger Things", "Ciencia Ficcion"))
            adaptadorSeries = AdapterSeries(arraySeries, applicationContext)
            adaptadorSeries.notifyDataSetChanged()*/
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}