package com.example.t6_menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t6_menus.adapters.AdaptadorPrueba
import com.example.t6_menus.databinding.ActivityMainBinding
import com.example.t6_menus.dialogs.DialogoAsignatura
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), DialogoAsignatura.OnDialogoAsignaturaListener {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var adaptadorPrueba: AdaptadorPrueba

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        //cambios en el toolbar
        supportActionBar?.title = "Vambio en el titulo"

        adaptadorPrueba = AdaptadorPrueba(this, ArrayList<String>())
        binding.recyclerPrueba.adapter = adaptadorPrueba
        binding.recyclerPrueba.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_prueba, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var texto: String = ""

        when (item.itemId) {
            R.id.menu_op1 -> {
                texto = "Elemento 1"
            }
            R.id.menu_op2 -> {
                texto = "Elemento 2"
            }
            R.id.menu_op1_1 -> {
                texto = "Elemento 1.1"
            }
            R.id.menu_op1_2 -> {
                texto = "Elemento 1.2"
            }
            R.id.menu_agregar -> {
                DialogoAsignatura().show(supportFragmentManager, "")
            }
            else -> {
                texto = "Elemento no identificado"

            }
        }
        Snackbar.make(binding.root, texto, Snackbar.LENGTH_SHORT).show()
        return true
    }

    override fun onAsignaturaSelected(asignatura: String) {
        adaptadorPrueba.lista.add(asignatura)
    }

}