package com.example.practicacartas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var botonEmpezar: Button;
    lateinit var textoNombre: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones(){
        botonEmpezar.setOnClickListener(this)
    }


    private fun instancias(){
        botonEmpezar = this.findViewById(R.id.boton_empezar);
        textoNombre = this.findViewById(R.id.texto_nombre);
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.boton_empezar ->{
                if (!textoNombre.text.isEmpty()) {
                    var intent: Intent = Intent(applicationContext,SecondActivity::class.java);
                    var bundle: Bundle = Bundle();
                    bundle.putString("nombre",textoNombre.text.toString())
                    intent.putExtras(bundle);
                    startActivity(intent)
                    textoNombre.setText("")
                } else {
                    Toast.makeText(applicationContext,"Por favor introduce nombre",Toast.LENGTH_LONG).show()
                    //Snackbar.make(v, "Por favor introduce nombre antes", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }


}