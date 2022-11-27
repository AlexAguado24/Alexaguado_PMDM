package com.example.hobbies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.hobbies.adapter.AdapterHobbies
import com.example.hobbies.databinding.ActivitySecondBinding
import com.example.hobbies.model.HobbieLista


class SecondActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivitySecondBinding
    lateinit var arrayFutbol: ArrayList<HobbieLista>
    lateinit var arraySeries: ArrayList<HobbieLista>
    lateinit var arrayJuegos: ArrayList<HobbieLista>
    lateinit var spinnerSencillo: ArrayAdapter<CharSequence>
    lateinit var adapterHobbies: AdapterHobbies;
    lateinit var objetoHobbie: HobbieLista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos()
        acciones()
    }

    private fun acciones() {
        binding.spinner.onItemSelectedListener = this
        binding.listaHobbies.setOnItemClickListener { adapterView, view, i, l ->
            //Hago visible el constrain y le actualizo los valores de sus objetos
            binding.secondConstrain.visibility = View.VISIBLE
            objetoHobbie = adapterHobbies.getItem(i) as HobbieLista
            binding.imagenItem.setImageResource(objetoHobbie.imagen)
            binding.nombreItem.setText(objetoHobbie.nombre)
            binding.generoItem.setText(objetoHobbie.genero)

        }
    }

    private fun asociarDatos() {
        //asocio el spinner y la lista con los adaptadors creados
        binding.spinner.adapter = spinnerSencillo
        binding.listaHobbies.adapter = adapterHobbies
    }

    private fun instancias() {

        //Relleno el array de futbol
        arrayFutbol = ArrayList()
        arrayFutbol.add(HobbieLista(R.drawable.maradona, "Maradona", "Argentina"))
        arrayFutbol.add(HobbieLista(R.drawable.messi, "Messi", "FC Barcelona"))
        arrayFutbol.add(HobbieLista(R.drawable.ronaldo, "Ronaldo", "Brasil"))
        arrayFutbol.add(HobbieLista(R.drawable.zidane, "Zidane", "Francia"))

        //Relleno el array de series
        arraySeries = ArrayList()
        arraySeries.add(HobbieLista(R.drawable.lost, "Perdidos", "Misterio"))
        arraySeries.add(HobbieLista(R.drawable.papel, "La casa de papel", "Accion"))
        arraySeries.add(HobbieLista(R.drawable.tronos, "GOT", "Fantasia"))
        arraySeries.add(HobbieLista(R.drawable.stranger, "Stranger Things", "Ciencia Ficcion"))


        //Relleno el array de juegos
        arrayJuegos = ArrayList()
        arrayJuegos.add(HobbieLista(R.drawable.ffx, "F. Fantasy", "Roll"))
        arrayJuegos.add(HobbieLista(R.drawable.god, "GOW", "Accion"))
        arrayJuegos.add(HobbieLista(R.drawable.gt, "Gran Turismo", "Carreras"))
        arrayJuegos.add(HobbieLista(R.drawable.metal, "Metal Gear", "Disparos"))

        //le doy al spinner los valores del string-array
        spinnerSencillo = ArrayAdapter.createFromResource(
            applicationContext,
            R.array.hobbies_spinner,
            android.R.layout.simple_spinner_dropdown_item
        )
        adapterHobbies = AdapterHobbies(arrayFutbol, applicationContext)

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        //Indico la seleccion del cambio en el spinner a traves de la posicion y lo vuelvo a rellenar
        if (p2 == 0) {
            adapterHobbies = AdapterHobbies(arrayFutbol, applicationContext)
            binding.listaHobbies.adapter = adapterHobbies
            /*arrayFutbol = ArrayList()
            arrayFutbol.add(HobbieLista(R.drawable.maradona, "Maradona", "Argentina"))
            arrayFutbol.add(HobbieLista(R.drawable.messi, "Messi", "FC Barcelona"))
            arrayFutbol.add(HobbieLista(R.drawable.ronaldo, "Ronaldo", "Brasil"))
            arrayFutbol.add(HobbieLista(R.drawable.zidane, "Zidane", "Francia"))
            adapterHobbies = AdapterHobbies(arrayFutbol, applicationContext)
            adapterHobbies.notifyDataSetChanged()*/
        } else if (p2 == 1) {
            adapterHobbies = AdapterHobbies(arrayJuegos, applicationContext)
            binding.listaHobbies.adapter = adapterHobbies
            /*arrayJuegos = ArrayList()
            arrayJuegos.add(HobbieLista(R.drawable.ffx, "F. Fantasy", "Roll"))
            arrayJuegos.add(HobbieLista(R.drawable.god, "GOW", "Accion"))
            arrayJuegos.add(HobbieLista(R.drawable.gt, "Gran Turismo", "Carreras"))
            arrayJuegos.add(HobbieLista(R.drawable.metal, "Metal Gear", "Disparos"))
            adapterHobbies = AdapterHobbies(arrayJuegos, applicationContext)
            adapterHobbies.notifyDataSetChanged()*/
        } else if (p2 == 2) {
            adapterHobbies = AdapterHobbies(arraySeries, applicationContext)
            binding.listaHobbies.adapter = adapterHobbies
            /*arraySeries = ArrayList()
            arraySeries.add(HobbieLista(R.drawable.lost, "Perdidos", "Misterio"))
            arraySeries.add(HobbieLista(R.drawable.papel, "La casa de papel", "Accion"))
            arraySeries.add(HobbieLista(R.drawable.tronos, "GOT", "Fantasia"))
            arraySeries.add(HobbieLista(R.drawable.stranger, "Stranger Things", "Ciencia Ficcion"))
            adapterHobbies = AdapterHobbies(arraySeries, applicationContext)
            adapterHobbies.notifyDataSetChanged()*/
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}