package com.example.t3_listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import com.example.t3_listas.adapters.AdapterPais
import com.example.t3_listas.databinding.ActivityMainBinding
import com.example.t3_listas.model.Pais
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var arrayPaises: ArrayList<Pais>;
    private lateinit var adaptadorSencillo: ArrayAdapter<Pais>
    private lateinit var adaptadorComplejo: AdapterPais

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        instancias();
        asociarDatos();
        acciones();
    }

    private fun acciones() {
        binding.listaPaises.setOnItemClickListener { adapterView, view, i, l ->
            var pais: Pais = adaptadorComplejo.getItem(i)
            Snackbar.make(view, "Numero de titulos ${pais.numeroTitulos}",Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun asociarDatos() {
        //binding.listaPaises.adapter = adaptadorSencillo
        binding.listaPaises.adapter = adaptadorComplejo
    }

    private fun instancias() {
        //adaptadorSencillo = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1,arrayPaises);
        //adaptadorSencillo.notifyDataSetChanged();
        adaptadorComplejo = AdapterPais(arrayPaises, applicationContext)
    }


}