package com.example.inicio_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button;
    lateinit var textoSaludo: TextView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // xml + kt
        Log.v("ciclo_vida", "Metodo onCreate ejecutado")
        botonPulsar = findViewById(R.id.boton_pulsar)
        textoSaludo = findViewById(R.id.texto_bienvenida)

        botonPulsar.setOnClickListener({
            Log.v("ciclo_vida", "Boton pulsado")
            textoSaludo.setText("Primera app completa")
        })
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida","onStar ejecutado")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida","onResuma ejecutado")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida","onPause ejecutado")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida","onStop ejecutado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida","onDestroy ejecutado")
    }

}