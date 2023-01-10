package com.example.t5_dialogos_practica.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t5_dialogos_practica.R
import com.google.android.material.snackbar.Snackbar

class DialogoConfirmacion: DialogFragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext())
        //titulo
        //builder.setTitle(resources.getString(R.string.titulo_dialogo));
        builder.setTitle("Titulo del cuadro de confirmaccion");

        //mensaje
        builder.setMessage("Mensaje de confirmacion para el usuario ¿Continuar?")
        //botones
        builder.setPositiveButton("OK"){ dialogInterface, i ->
            Toast.makeText(requireContext(),"Boton positivo", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancelar"){ dialogInterface, i ->
            Toast.makeText(requireContext(),"Boton negativo", Toast.LENGTH_SHORT).show()
        }


        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
    }
}