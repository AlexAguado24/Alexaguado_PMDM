package com.example.t6_menus.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t6_menus.R

class DialogoAsignatura : DialogFragment() {

    private lateinit var vista: View
    private lateinit var botonAceptar: Button
    private lateinit var editAsignatura: EditText
    private lateinit var listener: OnDialogoAsignaturaListener;


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogoAsignaturaListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext());
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_item,null)
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        instancias();

    }

    private fun instancias() {
        editAsignatura = vista.findViewById(R.id.edit_dialogo)
        botonAceptar = vista.findViewById(R.id.boton_dialogo)
    }

    override fun onResume() {
        super.onResume()
        acciones();
    }

    private fun acciones() {
        botonAceptar.setOnClickListener {
            listener.onAsignaturaSelected(editAsignatura.text.toString())
            dismiss()
        }
    }

    interface OnDialogoAsignaturaListener {
        fun onAsignaturaSelected(asignatura:String)
    }

}