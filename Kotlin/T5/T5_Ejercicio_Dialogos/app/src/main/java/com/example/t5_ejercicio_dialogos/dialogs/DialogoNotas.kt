package com.example.t5_ejercicio_dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t5_ejercicio_dialogos.R

class DialogoNotas: DialogFragment() {

    private lateinit var vista: View
    private lateinit var editNotas: EditText
    private lateinit var textoNotas: TextView
    private lateinit var botonNotas: Button
    private lateinit var listener: OnDialogoNotasListener



    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogoNotasListener
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_nota,null)
        builder.setView(vista)

        return builder.create()
    }

    fun instancias(){
        textoNotas = vista.findViewById(R.id.texto_notas)
        editNotas = vista.findViewById(R.id.edit_notas)
        botonNotas = vista.findViewById(R.id.boton_notas)
    }

    fun acciones(){
        botonNotas.setOnClickListener {
            listener.onNotasSelected(editNotas.text.toString())
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        instancias()
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    interface OnDialogoNotasListener{
        fun onNotasSelected(nota:String)
    }
}