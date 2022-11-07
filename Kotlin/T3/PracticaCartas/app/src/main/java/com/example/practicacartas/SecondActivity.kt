package com.example.practicacartas

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SecondActivity: AppCompatActivity(){

    lateinit var botonArriba: ImageButton;
    lateinit var botonAbajo: ImageButton;
    lateinit var imagenCarta: ImageButton;
    lateinit var nombreRecuperado: String;
    var numAleatorio: Int? = null;
    var contador: Int? = null;
    var cartaFuturo: Int = 0;

    var arrayCartas: Array<Int> = arrayOf(
        R.drawable.c1,
        R.drawable.c2,
        R.drawable.c3,
        R.drawable.c4,
        R.drawable.c5,
        R.drawable.c6,
        R.drawable.c7,
        R.drawable.c8,
        R.drawable.c9,
        R.drawable.c10,
        R.drawable.c11,
        R.drawable.c12,
        R.drawable.c13
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instancia()
        iniciarUI()
    }

    private fun iniciarUI(){
        var nombre = nombreRecuperado;
        var snackbarEmpezar =
            Snackbar.make(botonArriba, "Bienvenido $nombre", Snackbar.LENGTH_INDEFINITE)
        snackbarEmpezar.setAction("Empezar") {
            cogerCarta()
        }
        snackbarEmpezar.show()
    }

    private fun instancia() {

        botonArriba = findViewById(R.id.boton_arriba)
        botonAbajo = findViewById(R.id.boton_abajo)
        imagenCarta = findViewById(R.id.imagen_carta)
        botonArriba.setOnClickListener{

        }
        botonAbajo.setOnClickListener{

        }
    }
    private fun recuperarDatos(){
        var bundleRecuperado: Bundle? = intent.extras;
        nombreRecuperado = bundleRecuperado?.getString("nombre").toString()
    }
    private fun cogerCarta(){
        numAleatorio = (Math.random()*13).toInt();
        cartaFuturo = arrayCartas[numAleatorio!!]
        imagenCarta.setImageResource(arrayCartas[numAleatorio!!])

    }
}