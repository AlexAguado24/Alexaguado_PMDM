package com.example.t5_ejercicio_dialogos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.t5_ejercicio_dialogos.databinding.ActivityMainBinding
import com.example.t5_ejercicio_dialogos.dialogs.*

class MainActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener, DialogoPersonalizado.OnDialogoPersonalizadoListener,
    DialogoAsignatura.OnAsignaturasListener, DialogoNotas.OnDialogoNotasListener {

    private lateinit var binding: ActivityMainBinding
    private var hora: Int = 0
    private var minutos: Int = 0
    private var anio: Int = 0
    private var mes: Int = 0
    private var dia: Int = 0
    private lateinit var nombreApellido: String
    private lateinit var listaAsignaturas: ArrayList<String>
    private lateinit var valorMedia: String;
    private var cantidadAsignaturas: Int = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones();
        instancias();
    }

    private fun instancias() {
        listaAsignaturas = ArrayList();
        listaAsignaturas.forEach {
            cantidadAsignaturas++;
        }
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
        mes = month + 1;
        dia = dayOfMonth
        DialogoPersonalizado().show(supportFragmentManager, "")
    }

    override fun onDialogoPersoSelected(nombreYApellido: String) {
        nombreApellido = nombreYApellido
        val dialogo = DialogoConfirmacion.newInstance(nombreApellido, dia, mes, hora, minutos);
        dialogo.show(supportFragmentManager, "")
    }

    override fun onListaAsignaturasSelection(asignaturas: ArrayList<String>) {
        listaAsignaturas = asignaturas;

        DialogoNotas().show(supportFragmentManager, "")
    }

    override fun onNotasSelected(nota: String) {
        valorMedia = nota;
        val dialogoFinal = DialogoFinal.newInstance(
            nombreApellido,
            dia,
            mes,
            hora,
            minutos,
            cantidadAsignaturas,
            valorMedia
        )
        dialogoFinal.show(supportFragmentManager, "")
    }
}