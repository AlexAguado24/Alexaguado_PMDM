package com.example.inicio_android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button;
    lateinit var textoSaludo: TextView;
    lateinit var editNombre: EditText;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // xml + kt
        Log.v("ciclo_vida", "Metodo onCreate ejecutado")
        botonPulsar = findViewById(R.id.boton_pulsar)
        textoSaludo = findViewById(R.id.texto_bienvenida)
        editNombre = findViewById(R.id.edit_nombre)

        botonPulsar.setOnClickListener({view: View ->
            if (!editNombre.text.isEmpty()) {
                var texto = editNombre.text
                textoSaludo.setText(texto)
                editNombre.setText("")
            } else {
                Log.v("avisos","texto vacio")
            }
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

}