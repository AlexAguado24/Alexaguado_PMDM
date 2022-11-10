package com.example.practicacartas

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class SecondActivity: AppCompatActivity(){

    lateinit var botonArriba: ImageButton;
    lateinit var botonAbajo: ImageButton;
    lateinit var imagenCarta: ImageView;
    var nombreRecuperado: String? = null;
    var numAleatorio1: Int? = null;
    var numAleatorio2: Int? = null;
    var contador: Int? = null;
    var cartaFuturo: Int = 0;
    var cartaActual: Int = 0;

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
        recuperarDatos()
    }

    private fun iniciarUI(){
        botonArriba.visibility = View.GONE;
        botonAbajo.visibility = View.GONE;
        var snackbarEmpezar =
            Snackbar.make(botonArriba, "Bienvenido $nombreRecuperado", Snackbar.LENGTH_INDEFINITE)
        snackbarEmpezar.setAction("Empezar") {
            botonArriba.visibility = View.VISIBLE;
            botonAbajo.visibility = View.VISIBLE;
            cogerCarta()
        }
        snackbarEmpezar.show()
    }

    private fun instancia() {
        botonArriba = findViewById(R.id.boton_arriba)
        botonAbajo = findViewById(R.id.boton_abajo)
        imagenCarta = findViewById(R.id.imagen_carta)
        botonArriba.setOnClickListener{
            cogerCarta()
        }
        botonAbajo.setOnClickListener{
            cogerCarta()
        }
    }
    private fun recuperarDatos(){
        var bundleRecuperado: Bundle? = intent.extras;
        nombreRecuperado = bundleRecuperado?.getString("nombre").toString()
    }
    private fun cogerCarta(){
        numAleatorio1 = (Math.random()*13).toInt();
        numAleatorio2 = (Math.random()*13).toInt()
        cartaFuturo= arrayCartas[numAleatorio1!!]
        cartaActual = arrayCartas[numAleatorio2!!]
        imagenCarta.setImageResource(cartaActual)

    }
}