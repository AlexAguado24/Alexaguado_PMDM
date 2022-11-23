package com.example.t3_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3_spinner.databinding.ActivityDetailBinding
import com.example.t3_spinner.databinding.ActivityMainBinding
import com.example.t3_spinner.modelo.Pais

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarDatos();
    }

    private fun recuperarDatos() {
        //intent --> bundle -->datos
        var bundleRecuperado = intent.extras
        var equpo = bundleRecuperado!!.getSerializable("equipo") as Pais
        binding.etiquetaNombre.setText(equpo.nombre)
        binding.imagenDetalle.setImageResource(equpo.imagen)
        binding.textoEstrella.setText(equpo.estrella)
        binding.textoTitulos.setText(equpo.numeroTitulos).toString()
    }
}