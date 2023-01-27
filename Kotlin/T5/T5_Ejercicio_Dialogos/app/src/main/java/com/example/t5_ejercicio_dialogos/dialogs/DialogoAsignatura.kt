package com.example.t5_ejercicio_dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoAsignatura : DialogFragment() {

    private lateinit var asignaturasSeleccionadas: ArrayList<String>;
    private lateinit var listener: OnAsignaturasListener
    private lateinit var listaAsig: Array<String>


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        listaAsig = arrayOf("PMDM","DI","AD","SGE","EIE","ING")
        builder.setTitle("Asignaturas")
        builder.setMultiChoiceItems(listaAsig,null){ _, posicion, boolean ->
            if (boolean) {
                asignaturasSeleccionadas.add(listaAsig[posicion])
            } else {
                asignaturasSeleccionadas.remove(listaAsig[posicion])
            }
        }
        builder.setPositiveButton("Confirmar"){ _, _ -> run{
            listener.onListaAsignaturasSelection(asignaturasSeleccionadas)
        } }
        builder.setNegativeButton("Cancelar"){ _, _ -> run{} }

        return builder.create()
    }

    interface OnAsignaturasListener{
        fun onListaAsignaturasSelection(asignaturas: ArrayList<String>)
    }

}