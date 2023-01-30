package com.example.practicaasignaturas.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.practicaasignaturas.R
import com.example.practicaasignaturas.adapter.AdaptadorCiclos
import com.example.practicaasignaturas.model.Asignatura
import com.example.practicaasignaturas.model.Ciclo

class DialogoAsignatura : DialogFragment() {

    private lateinit var vista: View
    private lateinit var editAsignatura: EditText
    private lateinit var editSiglas: EditText
    private lateinit var editProfesor: EditText
    private lateinit var spinnerHoras: Spinner
    private lateinit var adaptadorHoras: ArrayAdapter<CharSequence>
    private lateinit var spinnerCiclo: Spinner
    private lateinit var adaptadorCiclos: AdaptadorCiclos
    private lateinit var spinnerCurso: Spinner
    private lateinit var adaptadorCurso: ArrayAdapter<CharSequence>
    private lateinit var botonGuardar: Button
    private lateinit var listener: OnCreateAsignaturaListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_asignatura, null)
        adaptadorHoras = ArrayAdapter.createFromResource(context, R.array.array_horas,android.R.layout.simple_spinner_item)
        adaptadorCurso = ArrayAdapter.createFromResource(context, R.array.array_cursos,android.R.layout.simple_spinner_item)
        var listaCiclos = ArrayList<Ciclo>()
        listaCiclos.add(Ciclo("DAM", R.drawable.img))
        listaCiclos.add(Ciclo("DAW", R.drawable.img_1))
        listaCiclos.add(Ciclo("ASIR", R.drawable.img_2))
        adaptadorCiclos = AdaptadorCiclos(context,listaCiclos)
        listener = context as OnCreateAsignaturaListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)

        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        instancias();
    }

    private fun instancias() {
        editAsignatura = vista.findViewById(R.id.edit_dialogo_nombre)
        editSiglas = vista.findViewById(R.id.edit_dialogo_siglas)
        editProfesor = vista.findViewById(R.id.edit_dialogo_profesor)
        spinnerHoras = vista.findViewById(R.id.spinner_horas)
        spinnerCiclo = vista.findViewById(R.id.spinner_ciclo)
        spinnerCurso = vista.findViewById(R.id.spinner_curso)
        spinnerHoras.adapter  = adaptadorHoras
        adaptadorHoras.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCurso.adapter  = adaptadorCurso
        adaptadorCurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCiclo.adapter = adaptadorCiclos
        botonGuardar = vista.findViewById(R.id.boton_guardar)
    }

    override fun onResume() {
        super.onResume()
        botonGuardar.setOnClickListener{
            var nombreAsignatura = editAsignatura.text.toString()
            var siglasAsignatura = editSiglas.text.toString()
            var profesorAsignatura = editProfesor.text.toString()
            var horas = adaptadorHoras.getItem(spinnerHoras.selectedItemPosition).toString()
            var ciclo = adaptadorCiclos.getItem(spinnerCiclo.selectedItemPosition)
            var curso = adaptadorCurso.getItem(spinnerCurso.selectedItemPosition).toString()
            var asignatura = Asignatura(nombreAsignatura,siglasAsignatura,profesorAsignatura,horas,ciclo.nombre,curso)
            listener.onAsignaturaCreated(asignatura)
        }
    }

    interface OnCreateAsignaturaListener{
        fun onAsignaturaCreated(asignatura: Asignatura)
    }
}