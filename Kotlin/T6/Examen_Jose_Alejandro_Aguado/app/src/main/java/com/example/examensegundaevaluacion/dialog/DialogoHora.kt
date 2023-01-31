package com.example.examensegundaevaluacion.dialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DialogoHora: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var calendario = Calendar.getInstance()
        var hora = calendario.get(Calendar.HOUR_OF_DAY)
        var minuto = calendario.get(Calendar.MINUTE)
        var dialogoHora = TimePickerDialog(requireContext(),requireContext() as OnTimeSetListener,hora,minuto,false)

        return dialogoHora
    }

}