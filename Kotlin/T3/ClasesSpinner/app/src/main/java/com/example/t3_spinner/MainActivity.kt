package com.example.t3_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.t3_spinner.adaptadores.AdaptadorPersonalizado
import com.example.t3_spinner.databinding.ActivityMainBinding
import com.example.t3_spinner.modelo.Pais
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityMainBinding;
    lateinit var arraySpinner: ArrayList<Pais>;
    lateinit var adaptadorSencillo: ArrayAdapter<CharSequence>;
    lateinit var adaptadorPersonalizado: AdaptadorPersonalizado;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos();
        rellenarSpinnerPersonalizado();
        acciones();
    }

    private fun acciones() {
        /*binding.spinnerSimple.setOnItemClickListener { adapterView, view, i, l ->
            Snackbar.make(binding.spinnerSimple,i.toString(),Snackbar.LENGTH_SHORT).show()
        }*/
        binding.spinnerSimple.onItemSelectedListener = this
        binding.spinnerComplejo.onItemSelectedListener = this
        binding.botonAgregar.setOnClickListener{
            var pais: Pais = Pais("Argentina", R.drawable.esc_argentina)
            //agregar un elemento desde la clase
            adaptadorPersonalizado.agregarPais(pais)
            //agregar un elemento a la lista desde la clase
            /*arraySpinner.add(pais)
            adaptadorPersonalizado.notifyDataSetChanged()*/
        }

    }

    private fun asociarDatos() {
        binding.spinnerSimple.adapter = adaptadorSencillo;
        binding.spinnerComplejo.adapter = adaptadorPersonalizado
    }

    private fun instancias() {
        arraySpinner = ArrayList()
        /*adaptadorSencillo =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, arraySpinner)*/
        adaptadorSencillo = ArrayAdapter.createFromResource(applicationContext,
            R.array.paises,android.R.layout.simple_spinner_item)
        //adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //lista + xml + context --> adapter
        adaptadorPersonalizado = AdaptadorPersonalizado(arraySpinner, applicationContext)
    }

    private fun rellenarSpinnerPersonalizado() {
        // para rellenar el spinner hace falta una lista de elementos
        //lista --> array o arraylist o recurso del sistema
        arraySpinner.add(Pais("España",R.drawable.esc_espania))
        arraySpinner.add(Pais("Brasil",R.drawable.es_brasil))
        arraySpinner.add(Pais("Alemania",R.drawable.esc_alemania))
        arraySpinner.add(Pais("Francia",R.drawable.esc_france))
        arraySpinner.add(Pais("Qatar",R.drawable.esc_qatar))
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p1!!.id){
            R.id.spinner_simple->{
                Log.v("testSpinner",adaptadorSencillo.getItem(p2).toString())
            }
            R.id.spinner_complejo->{
                Log.v("testSpinner",adaptadorPersonalizado.getItem(p2).toString())
            }
        }
        //Snackbar.make(p1!!,p2.toString(),Snackbar.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}