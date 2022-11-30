package com.example.jose_alejandro_aguado_merino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jose_alejandro_aguado_merino.adapter.AdaptadorModelos
import com.example.jose_alejandro_aguado_merino.databinding.ActivityModelosBinding
import com.example.jose_alejandro_aguado_merino.modelo.Coche

class ModelosActivity : AppCompatActivity() {
    lateinit var binding: ActivityModelosBinding;
    lateinit var listaCoches: ArrayList<Coche>
    lateinit var adapterModelo: AdaptadorModelos;
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityModelosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        instancias();
        /*binding.listaModelos.onItemSelectedListener = object : AdaptadorModelos*/
    }

    private fun instancias() {
        listaCoches = ArrayList();
        listaCoches.add(Coche("volswagen","arteon",2015,R.drawable.etiquetac,R.drawable.arteon))
        listaCoches.add(Coche("opel","astra",2010,R.drawable.etiquetaeco,R.drawable.astra))
        listaCoches.add(Coche("seat","cordoba",2012,R.drawable.etiquetac,R.drawable.cordoba))
        listaCoches.add(Coche("opel","corsa",2018,R.drawable.etiqueta0,R.drawable.corsa))
        listaCoches.add(Coche("volswagen","golf",2020,R.drawable.etiquetac,R.drawable.golf))
        listaCoches.add(Coche("seat","ibiza",2019,R.drawable.etiquetaeco,R.drawable.ibiza))
        listaCoches.add(Coche("opel","corsa",2021,R.drawable.etiquetaa,R.drawable.modelo_corsa))
        listaCoches.add(Coche("volswagen","tiguan",2022,R.drawable.etiquetaeco,R.drawable.tiguan))
        adapterModelo = AdaptadorModelos(listaCoches,applicationContext)
        binding.listaModelos.adapter = adapterModelo;
    }
}