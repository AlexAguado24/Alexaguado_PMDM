package com.example.dialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.dialogos.R

class DialogoPersonalizado : DialogFragment() {

    private lateinit var vista: View;
    private lateinit var contexto: Context
    private lateinit var botonLogin: Button
    private lateinit var editNombre: EditText
    private lateinit var editPass: EditText
    private lateinit var checkRecordar: CheckBox

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contexto = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_login, null);
        builder.setView(vista)

        return builder.create()
    }

    override fun onResume() {
        super.onResume()
        acciones()
    }

    fun acciones(){
        botonLogin.setOnClickListener {
            Log.v("dialogo", "boton del dialogo pulsado")
        }
    }

    fun instancias(){
        botonLogin = vista.findViewById(R.id.boton_login)
        editNombre = vista.findViewById(R.id.edit_nombre)
        editPass = vista.findViewById(R.id.edit_pass)
        checkRecordar = vista.findViewById(R.id.check_recordar)
    }

    override fun onStart() {
        super.onStart()
        instancias()
    }
}