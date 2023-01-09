package com.example.dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog

class DialogoLista: DialogFragment() {

    private lateinit var listener: OnListaListener;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnListaListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")
        builder.setTitle("Titulo de lista")

        //builder.setMessage("Mensaje de la lista")
        builder.setItems(elementos, DialogInterface.OnClickListener { dialogInterface, i ->
            // i --> posicion pulsada
            listener.onElementoListaSelected(elementos[i])
        })
        // no hay que poner botones --> como mucho pongo el neutral


        return builder.create();
    }

    interface OnListaListener {
        fun onElementoListaSelected(elemento: String);
    }

}