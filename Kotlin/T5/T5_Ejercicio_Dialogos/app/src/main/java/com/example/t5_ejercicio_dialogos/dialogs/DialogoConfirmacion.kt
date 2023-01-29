package com.example.t5_ejercicio_dialogos.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoConfirmacion : DialogFragment() {

    companion object {
        fun newInstance(
            nombreApellido: String,
            dia: Int,
            mes: Int,
            hora: Int,
            minutos: Int
        ): DialogoConfirmacion {
            val bundle = Bundle();
            bundle.putString("nombre", nombreApellido)
            bundle.putInt("dia", dia)
            bundle.putInt("mes", mes)
            bundle.putInt("hora", hora)
            bundle.putInt("minutos", minutos)
            val fragment = DialogoConfirmacion()
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        var nombreApellido = this.arguments?.get("nombre")
        var dia = this.arguments?.get("dia")
        var mes = this.arguments?.get("mes")
        var hora = this.arguments?.get("hora")
        var minutos = this.arguments?.get("minutos")
        builder.setMessage(
            "Buenos dias ${nombreApellido}," +
                    " vas a registrar una respuesta el ${dia}/${mes} a las ${hora}:${minutos}. ¿Estas seguro que quieres continuar?");
        builder.setPositiveButton("Si"){ _,_->
            DialogoAsignatura().show(parentFragmentManager, "")
        }
        builder.setNegativeButton("No"){ _,_-> }

        return builder.create()
    }

}