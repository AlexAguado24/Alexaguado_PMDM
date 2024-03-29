package com.example.inicio_android

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {

    lateinit var textoNombre: TextView;
    lateinit var imagenAndroid: ImageView;
    lateinit var nombreRecuperado: String;
    var edadRecuperada: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instacias()
        recuperarDatos()
        iniciarUI()
    }

    private fun iniciarUI() {
        textoNombre.setText(nombreRecuperado+ resources.getString(R.string.saludo_racuperado));
        imagenAndroid.setImageResource(R.drawable.ic_launcher_foreground)
        Log.v("datos_recuperados",edadRecuperada.toString())
    }

    private fun recuperarDatos() {
        //texto nombre lo recupero del bundle
        var bundleRecuperado: Bundle? = intent.extras;
        textoNombre.setText(nombreRecuperado+ resources.getString(R.string.saludo_racuperado));
        imagenAndroid.setImageResource(R.drawable.ic_launcher_background)
        nombreRecuperado = bundleRecuperado?.getString("nombre","por defecto").toString()
        edadRecuperada = bundleRecuperado?.getInt("edad",18) ?: 0

        Log.v("datos_recuperados",nombreRecuperado)
        Log.v("datos_recuperados",edadRecuperada.toString())

    }

    private fun instacias() {
        textoNombre = findViewById(R.id.texto_nombre)
        imagenAndroid = findViewById(R.id.imagen_android)
    }

}