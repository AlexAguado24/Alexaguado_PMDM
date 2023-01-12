package com.example.dialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DialogoMultiple : DialogFragment() {

    private lateinit var listener: OnListaMultipleSelected
    private lateinit var elementosSeleccionados: ArrayList<String>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnListaMultipleSelected
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val elementos = arrayOf("opcion1", "opcion2", "opcion3")
        var builder = AlertDialog.Builder(requireContext())

        builder.setMultiChoiceItems(elementos,null) { _, posicion, boolean ->
            Log.v("dialogos", "${posicion.toString()} ${boolean.toString()}")
        }

        builder.setPositiveButton("Ok"){_,_->
            Log.v("dialogos","realizar comunicacion")
        }
        builder.setNeutralButton("Salir"){_,_->
            Log.v("dialogos","cerrando dialogo")
        }

        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface OnListaMultipleSelected{
        fun onMultipleSelected(lista: ArrayList<String>);
    }
}