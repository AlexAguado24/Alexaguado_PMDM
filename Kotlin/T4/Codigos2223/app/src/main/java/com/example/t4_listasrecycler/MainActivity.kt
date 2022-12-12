package com.example.t4_listasrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t4_listasrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaUsuarios: ArrayList<Usuario>
    lateinit var adaptadorUsuarios: AdaptadorUsuarios;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias();
        configurarRecycler();
        //tener una lista de datos a representar

        //poner un adaptador dentro del recycler

        //poner un layout dentro del recycler --> Linear Grid
        binding.listaRecycler
    }

    private fun configurarRecycler() {
        binding.listaRecycler.adapter = adaptadorUsuarios

    }

    private fun instancias() {
        listaUsuarios = ArrayList()
        listaUsuarios.add(Usuario("Borja","Martin",1234,R.drawable.male))
        listaUsuarios.add(Usuario("celia","clark",4567,R.drawable.female))
        listaUsuarios.add(Usuario("carlos","cano",7891,R.drawable.male))
        listaUsuarios.add(Usuario("luchia","luz",12356,R.drawable.female))
        adaptadorUsuarios = AdaptadorUsuarios(listaUsuarios,this)
    }
}