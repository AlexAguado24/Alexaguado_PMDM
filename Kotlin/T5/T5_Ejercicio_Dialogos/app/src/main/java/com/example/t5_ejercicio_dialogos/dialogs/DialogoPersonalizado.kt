package com.example.t5_ejercicio_dialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.t5_ejercicio_dialogos.R

class DialogoPersonalizado: DialogFragment() {

    private lateinit var listener: OnDialogoPersonalizadoListener
    private lateinit var vista: View
    private lateinit var editNombreYApellido: EditText
    private lateinit var botonAceptar: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogoPersonalizadoListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_personalizado,null)
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        editNombreYApellido = vista.findViewById(R.id.edit_personalizado)
        botonAceptar = vista.findViewById(R.id.boton_personalizado)
    }

    override fun onResume() {
        super.onResume()
        botonAceptar.setOnClickListener {
            listener.onDialogoPersoSelected(editNombreYApellido.text.toString())
            dismiss()
        }
    }

    interface OnDialogoPersonalizadoListener{
        fun onDialogoPersoSelected(nombreYApellido: String)
    }
}