package com.example.t5_ejerciciorecycler.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.DialogFragment
import com.example.t5_ejerciciorecycler.R

class DialogoUsuario: DialogFragment() {

    private lateinit var vista:View

    companion object {
        /*fun newInstance(): {
            val args = Bundle()

            val fragment = ()
            fragment.arguments = args
            return fragment
        }*/
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())

        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_item,null)

        builder.setView(vista)
        return builder.create()
    }


}