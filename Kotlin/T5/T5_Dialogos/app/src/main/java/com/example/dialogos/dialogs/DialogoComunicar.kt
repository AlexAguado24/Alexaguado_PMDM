package com.example.dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoComunicar: DialogFragment() {

    private lateinit var nombre: String;

    companion object{
        // to-do lo declarado aqui es accesible
        //1. TODO creo un metodo  newInstance  como parametro se pone lo que va a recibir el dialogo
                //devuelve el objeto del tipo que quiero construir

        fun newInstance(nombre: String): DialogoComunicar{
            val  dialogo = DialogoComunicar();
            // 2. TODO creo los argumentos con los datos que van en los parametros y se lo pongo al cuadro

            val bundle = Bundle()
            bundle.putString("nombre", nombre)
            bundle.putString("mensaje", "Ejemplo de mensaje")
            dialogo.arguments = bundle
            return dialogo
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //3. TODO recupero los argumentos que quiero recuperar

        this. nombre = this.arguments?.getString("nombre") ?: "Sin nombre"
        this. nombre = this.arguments?.getString("mensaje") ?: "Sin mensaje"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle(nombre)


        return builder.create()
    }
}