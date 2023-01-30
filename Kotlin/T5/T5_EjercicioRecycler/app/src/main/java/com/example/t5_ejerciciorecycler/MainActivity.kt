package com.example.t5_ejerciciorecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t5_ejerciciorecycler.adapter.RecyclreTrabajadores
import com.example.t5_ejerciciorecycler.databinding.ActivityMainBinding
import com.example.t5_ejerciciorecycler.dialogs.DialogoUsuario
import com.example.t5_ejerciciorecycler.model.Usuario

class MainActivity : AppCompatActivity(), RecyclreTrabajadores.OnUsuarioRecyclerSelected {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var listaTrabajadores: ArrayList<Usuario>
    private lateinit var recyclerTrabajadores: RecyclreTrabajadores
    private lateinit var usuario: Usuario;
    private lateinit var puesto:String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias();
        configurarRecycler();
        acciones();
    }

    private fun acciones() {
        binding.botonGuardar.setOnClickListener {
            var nombre = binding.editNombre.text.toString()
            var apellido = binding.editApellido.text.toString()
            var edad = binding.editEdad.text.toString()

            listaTrabajadores.add(Usuario(nombre,apellido,edad,puesto))
            //recyclerTrabajadores.notifyDataSetChanged()
            recyclerTrabajadores.notifyItemInserted(listaTrabajadores.size)
        }
    }

    private fun configurarRecycler() {
        binding.recyclerUsuarios.adapter = recyclerTrabajadores
        binding.recyclerUsuarios.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    private fun instancias() {
        listaTrabajadores = ArrayList();
        recyclerTrabajadores = RecyclreTrabajadores(this,listaTrabajadores);
        var adapterSpinner = ArrayAdapter.createFromResource(this,R.array.spinner_trabajos,android.R.layout.simple_spinner_item)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTrabajo.adapter = adapterSpinner
        binding.spinnerTrabajo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                puesto = binding.spinnerTrabajo.selectedItem.toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    override fun onUsuarioClickListener(usuario: Usuario) {
        var usuario = usuario
        val dialogoUsuario = DialogoUsuario.
        DialogoUsuario().show(supportFragmentManager,"")
    }
}