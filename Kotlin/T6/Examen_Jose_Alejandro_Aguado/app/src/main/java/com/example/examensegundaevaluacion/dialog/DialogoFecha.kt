package com.example.examensegundaevaluacion.dialog

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DialogoFecha: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var calendario = Calendar.getInstance()
        var dia = calendario.get(Calendar.DAY_OF_MONTH)
        var mes = calendario.get(Calendar.MONTH)
        var anio = calendario.get(Calendar.YEAR)
        var dialogoHora = DatePickerDialog(requireContext(),requireContext() as OnDateSetListener,anio,mes,dia)


        return dialogoHora
    }
}