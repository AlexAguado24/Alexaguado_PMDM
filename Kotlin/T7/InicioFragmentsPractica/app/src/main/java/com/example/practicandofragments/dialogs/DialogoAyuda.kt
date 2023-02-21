package com.example.practicandofragments.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoAyuda: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Mensaje de ayuda")
        builder.setMessage("Cuadro de dialogo lanzado desde un fragment")

        return builder.create()
    }

}