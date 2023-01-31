package com.example.examensegundaevaluacion

import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog.OnTimeSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.example.examensegundaevaluacion.adapter.AdaptadorSpinner
import com.example.examensegundaevaluacion.databinding.ActivityMainBinding
import com.example.examensegundaevaluacion.dialog.AdaptadorVuelo
import com.example.examensegundaevaluacion.dialog.DialogoFecha
import com.example.examensegundaevaluacion.dialog.DialogoHora
import com.example.examensegundaevaluacion.dialog.DialogoInfo
import com.example.examensegundaevaluacion.model.Vuelo

class MainActivity : AppCompatActivity(), OnDateSetListener, OnTimeSetListener{

    private lateinit var binding: ActivityMainBinding;
    private lateinit var adaptadorOrigen: AdaptadorSpinner
    private lateinit var listaSpinner: ArrayList<Vuelo>
    private lateinit var adaptadorDestino: AdaptadorSpinner
    private lateinit var adaptadorRecyclre: AdaptadorVuelo
    private var dia: Int = 0
    private var mes: Int = 0
    private var anio: Int = 0
    private var hora: Int = 0
    private var minuto: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        instancias();
    }

    private fun instancias() {
        listaSpinner = ArrayList()
        listaSpinner.add(Vuelo("Barcelona",R.drawable.barcelona))
        listaSpinner.add(Vuelo("Londres",R.drawable.londres))
        listaSpinner.add(Vuelo("Madrid",R.drawable.madrid))
        listaSpinner.add(Vuelo("Miami",R.drawable.miami))
        listaSpinner.add(Vuelo("New York",R.drawable.newyork))
        listaSpinner.add(Vuelo("San Francisco",R.drawable.sanfrancisco))
        adaptadorOrigen = AdaptadorSpinner(this,listaSpinner)
        adaptadorDestino = AdaptadorSpinner(this,listaSpinner)
        binding.spinnerOrigen.adapter = adaptadorOrigen
        binding.spinnerDestino.adapter = adaptadorDestino
        adaptadorRecyclre = AdaptadorVuelo(this,listaSpinner)
        binding.recyclerVuelos.adapter = adaptadorRecyclre
        binding.textoOrigen.setOnClickListener{
            DialogoFecha().show(supportFragmentManager,"")

        }
        binding.textoDestino.setOnClickListener{
            DialogoFecha().show(supportFragmentManager,"")

        }
        binding.botonAgregar.setOnClickListener{

        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_info->{
                DialogoInfo().show(supportFragmentManager,"")
            }
            R.id.menu_cerrar->{
                MainActivity().finishActivity(1)
            }
        }
        return true
    }


    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        dia = dayOfMonth
        mes = month +1
        anio = year

        DialogoHora().show(supportFragmentManager,"")
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        hora = hourOfDay
        minuto = minute
        binding.textoOrigen.text = "${dia}/${mes}/${anio} - ${hora}/${minuto}"
        binding.textoDestino.text = "${dia}/${mes}/${anio} - ${hora}/${minuto}"
    }
}