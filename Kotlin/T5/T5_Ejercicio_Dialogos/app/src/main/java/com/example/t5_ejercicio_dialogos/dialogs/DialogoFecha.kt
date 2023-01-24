package com.example.t5_ejercicio_dialogos.dialogs

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DialogoFecha: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendario = Calendar.getInstance()
        val anio = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        println(mes)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val dialogo = DatePickerDialog(requireContext(), requireContext() as OnDateSetListener, anio,mes,dia)
        return dialogo
    }

}