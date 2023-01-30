package com.example.t5_ejerciciorecycler.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.t5_ejerciciorecycler.R
import com.example.t5_ejerciciorecycler.model.Usuario

class DialogoUsuario: DialogFragment() {

    private lateinit var vista:View
    private lateinit var textoNombre: TextView
    private lateinit var textoApellido: TextView
    private lateinit var textoEdad: TextView
    private lateinit var textoPuesto: TextView
    private lateinit var trabajador: Usuario


    companion object {
        fun newInstance(usuario: Usuario): DialogoUsuario{
            val bundle = Bundle()
            bundle.putSerializable("trabajador", usuario)
            val fragment = DialogoUsuario()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_item,null)
        builder.setView(vista)
        builder.setPositiveButton("Ok"){_,_->{} };
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        trabajador = this.arguments?.getSerializable("trabajador") as Usuario
    }

    override fun onStart() {
        super.onStart()
        instancias();
    }

    private fun instancias() {
        textoNombre = vista.findViewById(R.id.texto_nombre_dialogo)
        textoApellido = vista.findViewById(R.id.texto_apellido_dialogo)
        textoEdad = vista.findViewById(R.id.texto_edad_dialogo)
        textoPuesto = vista.findViewById(R.id.texto_puesto_dialogo)
        textoNombre.setText(trabajador.nombre)
        textoApellido.setText(trabajador.apellido)
        textoEdad.setText(trabajador.edad)
        textoPuesto.setText(trabajador.puesto)
    }
}