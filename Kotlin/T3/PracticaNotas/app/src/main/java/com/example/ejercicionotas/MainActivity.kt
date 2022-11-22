package com.example.ejercicionotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.ejercicionotas.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones();
    }

    private fun acciones() {
        //Cambio de ppantalla y envio de datos
        binding.botonIniciar.setOnClickListener {
            if (binding.editNombre.text.isNotEmpty() && binding.editApellido.text.isNotEmpty()) {
                var intent: Intent = Intent(applicationContext,SecondActivity::class.java);
                var bundle: Bundle = Bundle();
                bundle.putString("nombre", binding.editNombre.text.toString())
                bundle.putString("apellido", binding.editApellido.text.toString())
                intent.putExtras(bundle)
                startActivity(intent)
                binding.editNombre.setText("")
                binding.editApellido.setText("")
            } else {
                Snackbar.make(binding.botonIniciar,"Faltan datos en los espacios", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}