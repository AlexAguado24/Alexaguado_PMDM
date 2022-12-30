package com.example.recyclerusuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerusuarios.adapter.AdaptadorUsuarios
import com.example.recyclerusuarios.databinding.ActivityMainBinding
import com.example.recyclerusuarios.model.Usuario

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var listaUsuarios: ArrayList<Usuario>
    private lateinit var adaptadorUsuarios: AdaptadorUsuarios

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        instancias();
        configurarRecycler()
        acciones()
        binding.listaRecycler

    }

    private fun acciones() {

    }

    private fun configurarRecycler() {
        //2- poner un adaptador dentro del recycler
        binding.listaRecycler.adapter = adaptadorUsuarios
        //3- poner un layout dentro del recycler
        binding.listaRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    private fun instancias() {
        //1- tener la lista de datos
        listaUsuarios = ArrayList()
        listaUsuarios.add(Usuario("borja","martin", 1234,R.drawable.male))
        listaUsuarios.add(Usuario("maria","magda", 1235,R.drawable.female))
        listaUsuarios.add(Usuario("paca","pache", 4561,R.drawable.female))
        listaUsuarios.add(Usuario("puto","gonso", 4567,R.drawable.male))
        listaUsuarios.add(Usuario("pelao","martin", 7894,R.drawable.male))
        listaUsuarios.add(Usuario("pelao","martin", 7894,R.drawable.male))
        listaUsuarios.add(Usuario("pelao","martin", 7894,R.drawable.male))
        listaUsuarios.add(Usuario("pelao","martin", 7894,R.drawable.male))
        listaUsuarios.add(Usuario("pelao","martin", 7894,R.drawable.male))
        listaUsuarios.add(Usuario("pelao","martin", 7894,R.drawable.male))
        adaptadorUsuarios = AdaptadorUsuarios(listaUsuarios,this)

    }


}