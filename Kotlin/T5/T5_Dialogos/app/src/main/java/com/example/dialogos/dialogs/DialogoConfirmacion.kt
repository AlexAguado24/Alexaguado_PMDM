package com.example.dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogos.R

class DialogoConfirmacion : DialogFragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        //Builder --> creador
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        // titulo
        builder.setTitle("Titulo del cuadro de dialogo")
        builder.setTitle(resources.getString(R.string.titulo_dialogo))
        //mensajes
        builder.setMessage("¿Estas seguro que quieres continuar?")

        //botones
        builder.setPositiveButton("OK") { dialog, which ->
            Toast.makeText(
                requireContext(),
                "Pulsado positivo",
                Toast.LENGTH_SHORT
            ).show()
        }
        builder.setNegativeButton("Cancelar") { dialog, which ->
            Toast.makeText(
                requireContext(),
                "Pulsado negativo",
                Toast.LENGTH_SHORT
            ).show()
        }
        builder.setNeutralButton("Neutral") { dialog, which ->
            Toast.makeText(
                requireContext(),
                "Pulsado neutral",
                Toast.LENGTH_SHORT
            ).show()
        }

        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
    }

}