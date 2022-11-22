package com.example.ejercicionotas

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicionotas.databinding.ActivityMainBinding

class SecondActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    lateinit var nombreRecuperado: String
    lateinit var apellidoRecuperado: String
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarDatos();
    }

    private fun recuperarDatos() {
        var bundleRecuperado = intent.extras;
        nombreRecuperado = bundleRecuperado!!.getString("nombre").toString()
        apellidoRecuperado = bundleRecuperado!!.getString("apellido").toString()
    }
}