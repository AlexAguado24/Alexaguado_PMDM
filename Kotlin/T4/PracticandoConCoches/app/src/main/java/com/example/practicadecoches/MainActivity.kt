package com.example.practicadecoches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicadecoches.databinding.ActivityMainBinding
import com.example.practicadecoches.model.Coche

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var listaCoches: ArrayList<Coche>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
    }

    private fun instancias() {
        listaCoches = ArrayList()
        listaCoches.add(Coche("mercedes","amggt",300,120000,R.drawable.amggt))
        listaCoches.add(Coche("bentley","continental",250,100000,R.drawable.continental))
        listaCoches.add(Coche("jaguar","ftype",280,90000,R.drawable.ftype))
        listaCoches.add(Coche("ford","gt40",270,85000,R.drawable.gt40))
        listaCoches.add(Coche("nissan","gtr",290,15000,R.drawable.gtr))
        listaCoches.add(Coche("pagini","huayra",500,1000000,R.drawable.huayra))
        listaCoches.add(Coche("lexus","lc",470,180000,R.drawable.lc))
        listaCoches.add(Coche("ferrari","leferrari",490,500000,R.drawable.leferrari))
        listaCoches.add(Coche("noble","mc600",480,390000,R.drawable.mc600))
        listaCoches.add(Coche("toyota","supra",260,95000,R.drawable.supra))
        listaCoches.add(Coche("porche","taycan",330,250000,R.drawable.taycan))
    }
}