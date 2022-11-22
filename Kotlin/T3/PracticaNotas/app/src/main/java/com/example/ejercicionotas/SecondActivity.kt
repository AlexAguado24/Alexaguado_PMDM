package com.example.ejercicionotas

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicionotas.databinding.ActivityMainBinding
import com.example.ejercicionotas.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(){
    lateinit var binding: ActivitySecondBinding
    lateinit var nombreRecuperado: String
    lateinit var apellidoRecuperado: String
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarDatos();
    }

    private fun recuperarDatos() {
        var bundleRecuperado = intent.extras;
        nombreRecuperado = bundleRecuperado!!.getString("nombre").toString()
        apellidoRecuperado = bundleRecuperado!!.getString("apellido").toString()
    }
}