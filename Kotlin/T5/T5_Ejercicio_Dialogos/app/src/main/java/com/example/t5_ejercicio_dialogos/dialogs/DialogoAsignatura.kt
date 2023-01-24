package com.example.t5_ejercicio_dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View.OnClickListener
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t5_ejercicio_dialogos.models.Asignatura

class DialogoAsignatura : DialogFragment() {

    private lateinit var asignaturasSeleccionadas: ArrayList<Asignatura>;
    private lateinit var listener: OnAsignaturasListener
    private lateinit var listaAsig: Array<Asignatura>


    companion object {
        fun newInstance(asignaturas: ArrayList<Asignatura>): DialogoAsignatura {
            val bundle = Bundle()
            bundle.putSerializable("lista", asignaturas)
            val fragment = DialogoAsignatura()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        /*listaAsig = arrayOf(arguments?.get("lista"))
        builder.setTitle("Asignaturas")
        builder.setMultiChoiceItems(listaAsig,null){_,posicion,boolean ->

        }*/

        return builder.create()
    }

    interface OnAsignaturasListener{
        fun onListaAsignaturasSelection(listaAsignaturas: ArrayList<Asignatura>)
    }

}