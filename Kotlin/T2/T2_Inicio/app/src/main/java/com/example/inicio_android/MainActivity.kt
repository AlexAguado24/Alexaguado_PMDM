package com.example.inicio_android

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var botonPulsar: Button;
    lateinit var textoSaludo: TextView;
    lateinit var editNombre: EditText;
    lateinit var botonPasar: Button;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // xml + kt
        Log.v("ciclo_vida", "Metodo onCreate ejecutado")
        botonPulsar = findViewById(R.id.boton_pulsar)
        textoSaludo = findViewById(R.id.texto_bienvenida)
        editNombre = findViewById(R.id.edit_nombre)
        botonPasar = findViewById(R.id.boton_pasar)

        botonPasar.setOnClickListener(this)
            /*Toast.makeText(applicationContext,"Toast completada", Toast.LENGTH_SHORT).show()*/



        botonPulsar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.boton_pulsar -> {
                if (!editNombre.text.isEmpty()) {
                    var texto = editNombre.text
                    textoSaludo.setText(texto)
                    editNombre.setText("")
                } else {
                    Log.v("avisos","texto vacio")
                }
            }
            R.id.boton_pasar -> {
                var notificacion = Snackbar.make(p0!!, "Snack completado", Snackbar.LENGTH_LONG)
                notificacion.setAction("Seguro que quieres cerrar",{
                    var intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                    var datos: Bundle = Bundle();
                    datos.putString("nombre", editNombre.text.toString())
                    intent.putExtras(datos)
                    startActivity(intent)
                })
                notificacion.show()
            }
        }
    }
    /*override fun onStart() {
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
    }*/
}