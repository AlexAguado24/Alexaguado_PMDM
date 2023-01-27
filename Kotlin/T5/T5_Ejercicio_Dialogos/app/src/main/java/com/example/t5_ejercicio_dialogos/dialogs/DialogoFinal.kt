package com.example.t5_ejercicio_dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t5_ejercicio_dialogos.R

class DialogoFinal: DialogFragment() {

    private lateinit var vista: View;
    private lateinit var textoNombre: TextView
    private lateinit var textoHora: TextView
    private lateinit var textoFecha: TextView
    private lateinit var textoAsignaturas: TextView
    private lateinit var textoMedia: TextView

    companion object {
        fun newInstance(nombre:String,dia: Int,mes:Int,hora:Int,minutos:Int,numAsignaturas:Int, media:String): DialogoFinal{
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            bundle.putInt("dia",dia)
            bundle.putInt("mes",mes)
            bundle.putInt("hora",hora)
            bundle.putInt("minutos",minutos)
            bundle.putInt("asignaturas",numAsignaturas)
            bundle.putString("media",media)
            val fragment = DialogoFinal()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext());
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_final,null);
        builder.setView(vista)
        return builder.create()
    }

    fun instancias(){
        textoNombre = vista.findViewById(R.id.nombre_apellido_final)
        textoHora = vista.findViewById(R.id.hora_final)
        textoFecha = vista.findViewById(R.id.fecha_final)
        textoAsignaturas = vista.findViewById(R.id.num_asignaturas_final)
        textoMedia = vista.findViewById(R.id.media_final)
    }

    override fun onStart() {
        super.onStart()
        instancias()
    }

    override fun onResume() {
        super.onResume()
    }

}