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
    private lateinit var botonMenos: Button;
    private lateinit var botonMulti: Button;
    private lateinit var botonDiv: Button;
    private lateinit var botonPorcentaje: Button;
    private lateinit var botonMasMenos: Button;
    private lateinit var botonBorrar: Button;
    private var botonEquiExcla: Button? = null;
    private var botonRaiz: Button? = null;
    private var botonPotencia: Button? = null;
    private var botonLog: Button? = null;
    private var botonE: Button? = null;
    private lateinit var editNumeros: EditText;
    private lateinit var text: String;
    private var opUno: Double = 0.0;
    private var opDos: Double = 0.0;
    private var resultado: Double = 0.0;

    private lateinit var signo: String;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias();
        acciones();
        /*supportActionBar?.hide();*/
    }

    private fun acciones() {
        botonUno.setOnClickListener(this)
        botonDos.setOnClickListener(this)
        botonTres.setOnClickListener(this)
        botonCuatro.setOnClickListener(this)
        botonCinco.setOnClickListener(this)
        botonSeis.setOnClickListener(this)
        botonSiete.setOnClickListener(this)
        botonOcho.setOnClickListener(this)
        botonNueve.setOnClickListener(this)
        botonCero.setOnClickListener(this)
        botonComa.setOnClickListener(this)
        botonIgual.setOnClickListener(this)
        botonMas.setOnClickListener(this)
        botonMenos.setOnClickListener(this)
        botonMulti.setOnClickListener(this)
        botonDiv.setOnClickListener(this)
        botonPorcentaje.setOnClickListener(this)
        botonMasMenos.setOnClickListener(this)
        botonBorrar.setOnClickListener(this)
        botonEquiExcla?.setOnClickListener(this)
        botonRaiz?.setOnClickListener(this)
        botonPotencia?.setOnClickListener(this)
        botonLog?.setOnClickListener(this)
        botonE?.setOnClickListener(this)
    }

    private fun instancias() {
        editNumeros = findViewById(R.id.edit_numeros)
        botonUno = findViewById(R.id.boton_uno)
        botonDos = findViewById(R.id.boton_dos)
        botonTres = findViewById(R.id.boton_tres)
        botonCuatro = findViewById(R.id.boton_cuatro)
        botonCinco = findViewById(R.id.boton_cinco)
        botonSeis = findViewById(R.id.boton_seis)
        botonSiete = findViewById(R.id.boton_siete)
        botonOcho = findViewById(R.id.boton_ocho)
        botonNueve = findViewById(R.id.boton_nueve)
        botonCero = findViewById(R.id.boton_cero)
        botonComa = findViewById(R.id.boton_coma)
        botonIgual = findViewById(R.id.boton_igual)
        botonMas = findViewById(R.id.boton_mas)
        botonMenos = findViewById(R.id.boton_menos)
        botonMulti = findViewById(R.id.boton_multi)
        botonDiv = findViewById(R.id.boton_div)
        botonPorcentaje = findViewById(R.id.boton_porcentaje)
        botonMasMenos = findViewById(R.id.boton_mas_menos)
        botonBorrar = findViewById(R.id.boton_borrar)
        botonEquiExcla = findViewById(R.id.boton_equis_excla)
        botonRaiz = findViewById(R.id.boton_raiz)
        botonPotencia = findViewById(R.id.boton_potencia)
        botonLog = findViewById(R.id.boton_log)
        botonE = findViewById(R.id.boton_e)
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
            R.id.boton_cinco->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.boton_seis->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.boton_siete->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.boton_ocho->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.boton_nueve->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.boton_cero->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.boton_borrar->{
                editNumeros.setText("")
                opUno = 0.0
            }
            R.id.boton_coma->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.boton_mas->{
                signo = (p0 as Button).text.toString()
                text = editNumeros.text.toString()
                opUno = text.toDouble()
                editNumeros.setText("")
            }
            R.id.boton_menos->{
                signo = (p0 as Button).text.toString()
                text = editNumeros.text.toString()
                opUno = text.toDouble()
                editNumeros.setText("")
            }
            R.id.boton_multi->{
                signo = (p0 as Button).text.toString()
                text = editNumeros.text.toString()
                opUno = text.toDouble()
                editNumeros.setText("")
            }
            R.id.boton_div->{
                signo = (p0 as Button).text.toString()
                text = editNumeros.text.toString()
                opUno = text.toDouble()
                editNumeros.setText("")
            }
            R.id.boton_porcentaje->{
                signo = (p0 as Button).text.toString()
                text = editNumeros.text.toString()
                opUno = text.toDouble()
                editNumeros.setText("")
            }
            R.id.boton_mas_menos->{
                text = editNumeros.text.toString()
                opUno = text.toDouble() * -1
                editNumeros.setText(opUno.toString())
            }
            R.id.boton_e->{
                opUno = 2.718;
                editNumeros.setText(opUno.toString())
            }
            R.id.boton_igual->{
                text = editNumeros.text.toString()
                opDos = text.toDouble()
                when (signo) {
                    "+"->{
                        resultado = opUno.plus(opDos)
                        editNumeros.setText(resultado.toString())
                    }
                    "-"->{
                        resultado = opUno.minus(opDos)
                        editNumeros.setText(resultado.toString())
                    }
                    "X"->{
                        resultado = opUno.times(opDos)
                        editNumeros.setText(resultado.toString())
                    }
                    "/"->{
                        resultado = opUno.div(opDos)
                        editNumeros.setText(resultado.toString())
                    }
                    "%"->{
                        resultado = opUno.rem(opDos)
                        editNumeros.setText(resultado.toString())
                    }
                }
            }
        }
    }
}