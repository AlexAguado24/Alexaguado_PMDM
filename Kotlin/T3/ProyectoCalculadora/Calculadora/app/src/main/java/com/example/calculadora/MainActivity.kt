package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var botonUno: Button;
    private lateinit var botonDos: Button;
    private lateinit var botonTres: Button;
    private lateinit var botonCuatro: Button;
    private lateinit var botonCinco: Button;
    private lateinit var botonSeis: Button;
    private lateinit var botonSiete: Button;
    private lateinit var botonOcho: Button;
    private lateinit var botonNueve: Button;
    private lateinit var botonCero: Button;
    private lateinit var botonComa: Button;
    private lateinit var botonIgual: Button;
    private lateinit var botonMas: Button;
    private var botonTres: Button? = null;
    private var botonCuatro: Button? = null;
    private lateinit var editNumeros: EditText;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias();
        acciones();

    }

    private fun acciones() {
        botonUno.setOnClickListener(this)
        botonDos.setOnClickListener(this)
        botonTres?.setOnClickListener(this)
        botonCuatro?.setOnClickListener(this)
    }

    private fun instancias() {
        botonUno = findViewById(R.id.boton_uno)
        botonDos = findViewById(R.id.boton_dos)
        botonTres = findViewById(R.id.boton_tres)
        botonCuatro = findViewById(R.id.boton_cuatro)
        editNumeros = findViewById(R.id.edit_numeros)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.boton_uno->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.boton_dos->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.boton_tres->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.boton_cuatro->{
                editNumeros.append((p0 as Button).text)
            }
        }
    }
}