package com.example.practicacartas

import android.content.Intent
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
    lateinit var imagenCarta: ImageView ;
    lateinit var nombreRecuperado: String;
    var numAleatorio1: Int = 0;
    var numAleatorio2: Int = 0;
    var contador: Int = 0;

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
        recuperarDatos()
        instancia()
        iniciarUI()
        acciones()
    }

    private fun acciones() {
        botonArriba.setOnClickListener{
            numAleatorio2 = (Math.random()*13).toInt()
            if (numAleatorio1 < numAleatorio2) {
                imagenCarta.setImageResource(arrayCartas[numAleatorio2!!])
                numAleatorio1 = numAleatorio2
                contador++;
            } else if (numAleatorio1>numAleatorio2){
                terminarJuego()
            }
        }
        botonAbajo.setOnClickListener{
            numAleatorio2 = (Math.random()*13).toInt()
            if (numAleatorio1 > numAleatorio2) {
                imagenCarta.setImageResource(arrayCartas[numAleatorio2!!])
                numAleatorio1 = numAleatorio2
                contador++;
            } else if (numAleatorio1 < numAleatorio2){
                terminarJuego()
            }
        }
    }

    private fun iniciarUI(){
        //nombreRecuperado = bundleRecuperado?.getString("nombre",).toString()
        botonArriba.visibility = View.GONE;
        botonAbajo.visibility = View.GONE;
        var snackbarEmpezar =
            Snackbar.make(botonArriba, "Bienvenido $nombreRecuperado", Snackbar.LENGTH_INDEFINITE)
        snackbarEmpezar.setAction("Empezar") {
            botonArriba.visibility = View.VISIBLE;
            botonAbajo.visibility = View.VISIBLE;
            numAleatorio1 = (Math.random()*13).toInt();
            imagenCarta.setImageResource(arrayCartas[numAleatorio1!!])
            /*numAleatorio2 = (Math.random()*13).toInt()
            numAleatorio1 = (Math.random()*13).toInt();
            cartaFuturo= arrayCartas[numAleatorio1!!]
            imagenCarta.setImageResource(cartaFuturo)*/
        }
        snackbarEmpezar.show()
    }

    private fun instancia() {
        botonArriba = findViewById(R.id.boton_arriba)
        botonAbajo = findViewById(R.id.boton_abajo)
        imagenCarta = findViewById(R.id.imagen_carta)
    }
    private fun recuperarDatos(){
        var bundleRecuperado = intent.extras;
        nombreRecuperado = bundleRecuperado!!.getString("nombre",).toString()
    }
    private fun terminarJuego(){
        botonArriba.visibility = View.GONE;
        botonAbajo.visibility = View.GONE;
        var mensajeFinal =
            Snackbar.make(botonArriba, "Has perdido con $contador puntos", Snackbar.LENGTH_INDEFINITE)
        mensajeFinal.setAction("Continuar"){
            var intent: Intent = Intent(applicationContext,MainActivity::class.java);
            startActivity(intent)
        }
        mensajeFinal.show()
    }
}