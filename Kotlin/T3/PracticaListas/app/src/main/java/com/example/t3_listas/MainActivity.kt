package com.example.t3_listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.t3_listas.adapters.AdapterPais
import com.example.t3_listas.databinding.ActivityMainBinding
import com.example.t3_spinner.modelo.Pais
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var arrayPaises: ArrayList<Pais>
    lateinit var adaptadorSencillo: ArrayAdapter<Pais>
    lateinit var adaptadorPersonalizado: AdapterPais

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos();
        acciones();
    }

    private fun acciones() {
        binding.listaPaises.setOnItemClickListener { adapterView, view, i, l ->
            var pais: Pais = adaptadorPersonalizado.getItem(i)
            Snackbar.make(view,"numero titulos ${pais.numeroTitulos}",Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun asociarDatos() {
       // binding.listaPaises.adapter = adaptadorSencillo;
        binding.listaPaises.adapter = adaptadorPersonalizado;
    }

    private fun instancias() {
        arrayPaises = ArrayList()
        arrayPaises.add(Pais("España",R.drawable.esc_espania,1,"Pedri"))
        arrayPaises.add(Pais("Brasil",R.drawable.es_brasil,5,"Neymar"))
        arrayPaises.add(Pais("Alemania",R.drawable.esc_alemania,4,"Muller"))
        arrayPaises.add(Pais("Francia",R.drawable.esc_france,2,"Mbappe"))
        arrayPaises.add(Pais("Qatar",R.drawable.esc_qatar,0,"Desconocido"))
        arrayPaises.add(Pais("Argentina",R.drawable.esc_argentina,2,"Messi"))
        //adaptadorSencillo = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,listaPaises)
        //adaptadorSencillo.notifyDataSetChanged()
        adaptadorPersonalizado = AdapterPais(arrayPaises,applicationContext)
    }


}