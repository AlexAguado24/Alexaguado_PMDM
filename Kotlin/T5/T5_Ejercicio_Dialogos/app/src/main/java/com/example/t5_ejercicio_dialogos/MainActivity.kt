package com.example.t5_ejercicio_dialogos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.t5_ejercicio_dialogos.databinding.ActivityMainBinding
import com.example.t5_ejercicio_dialogos.dialogs.DialogoFecha
import com.example.t5_ejercicio_dialogos.dialogs.DialogoHora
import com.example.t5_ejercicio_dialogos.dialogs.DialogoPersonalizado

class MainActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener, DialogoPersonalizado.OnDialogoPersonalizadoListener {

    private lateinit var binding: ActivityMainBinding
    private var hora: Int = 0
    private var minutos: Int = 0
    private var anio: Int = 0
    private var mes: Int = 0
    private var dia: Int = 0
    private lateinit var nombreApellido: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones();
    }

    private fun acciones() {
        binding.botonArrancar.setOnClickListener {
            DialogoHora().show(supportFragmentManager, "")
        }
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        hora = hourOfDay
        minutos = minute
        DialogoFecha().show(supportFragmentManager, "")
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        anio = year
        mes = month
        dia = dayOfMonth
        DialogoPersonalizado().show(supportFragmentManager,"")
    }

    override fun onDialogoPersoSelected(nombreYApellido: String) {
        nombreApellido = nombreYApellido
    }
}