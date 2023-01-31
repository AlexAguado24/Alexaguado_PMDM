package com.example.examensegundaevaluacion.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoInfo: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Informacion del examen")
        builder.setMessage("Jose Alejandro Aguado \n" +
                "jose.aguado@cesjuanpablosegundo.es")

        return builder.create()
    }

}