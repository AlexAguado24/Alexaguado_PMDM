package com.example.ejercicionotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.ejercicionotas.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var editNombre: EditText
    lateinit var editApellido: EditText
    lateinit var botonIniciar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones();
    }

    private fun acciones() {
        binding.botonIniciar.setOnClickListener {
            if (editNombre.text.isNotEmpty() && editApellido.text.isNotEmpty()) {

            }
        }
    }


}