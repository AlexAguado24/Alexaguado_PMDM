package com.example.dialogos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.dialogos.databinding.ActivityMainBinding
import com.example.dialogos.dialogs.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener,
    DialogoConfirmacion.OnDialogoConfirmListener, DialogoLista.OnListaListener,
    DialogoMultiple.OnListaMultipleSelected, DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener, DialogoPersonalizado.OnDialogoPersonalizadoListener{

    private lateinit var binding: ActivityMainBinding
    private var dialogoConfirm: DialogoConfirmacion;

    init {
        dialogoConfirm = DialogoConfirmacion()
        dialogoConfirm.funcionNula = { elemento ->
            if (elemento) {
                Snackbar.make(binding.root, "Seleccionado true", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(binding.root, "Seleccionado false", Snackbar.LENGTH_SHORT).show()
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.botonConfirmacion.setOnClickListener(this)
        binding.botonLista.setOnClickListener(this)
        binding.botonPersonalizado.setOnClickListener(this)
        binding.botonComunicar.setOnClickListener(this)
        binding.botonFecha.setOnClickListener(this)
        binding.botonHora.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            binding.botonConfirmacion.id -> {
                //saltar el cuadro de dialogo
                //show() parte del cuadro de DialogFragment
                val dialogoConfirmacion = DialogoConfirmacion()
                dialogoConfirmacion.show(supportFragmentManager, "")
            }
            binding.botonLista.id -> {
                DialogoLista().show(supportFragmentManager, "")
            }
            binding.botonMultiple.id -> {
                DialogoMultiple().show(supportFragmentManager, "")
            }
            binding.botonPersonalizado.id -> {
                DialogoPersonalizado().show(supportFragmentManager, "")
            }
            binding.botonComunicar.id -> {
                DialogoComunicar.newInstance("Borja").show(supportFragmentManager, "")
            }
            binding.botonFecha.id -> {
                DialogoFecha().show(supportFragmentManager,"")
            }
            binding.botonHora.id -> {
                DialogoHora().show(supportFragmentManager,"")
            }
        }
    }

    override fun onDielogoSelected(seleccionado: Boolean) {
        if (seleccionado) {
            Snackbar.make(binding.root, "Seleccionado true", Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(binding.root, "Seleccionado false", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onElementoListaSelected(elemento: String) {
        binding.textoLista.text = elemento
    }

    override fun onMultipleSelected(lista: ArrayList<String>) {
        binding.textoMultiple.text = lista.size.toString()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Log.v("fecha","${year} ${month} ${dayOfMonth}")
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        Log.v("fecha","${hourOfDay} ${minute}")
    }

    override fun onDialogoSelected(nombre: String, pass: String) {
        binding.textoPersonalizado.text = "${nombre}\n${pass}"
    }


}