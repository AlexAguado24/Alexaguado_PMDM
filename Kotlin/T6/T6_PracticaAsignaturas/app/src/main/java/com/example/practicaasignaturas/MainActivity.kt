package com.example.practicaasignaturas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaasignaturas.adapter.AdaptadorAsignatura
import com.example.practicaasignaturas.databinding.ActivityMainBinding
import com.example.practicaasignaturas.dialog.DialogoAsignatura
import com.example.practicaasignaturas.model.Asignatura

class MainActivity : AppCompatActivity(), DialogoAsignatura.OnCreateAsignaturaListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaAsignaturas: ArrayList<Asignatura>
    private lateinit var adaptador: AdaptadorAsignatura

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Asignaturas"
        instancias();
    }

    private fun instancias() {
        listaAsignaturas = ArrayList()
        adaptador = AdaptadorAsignatura(this, listaAsignaturas)
        binding.recyclerAsignaturas.adapter = adaptador
        binding.recyclerAsignaturas.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add -> {
                DialogoAsignatura().show(supportFragmentManager, "")
            }
            R.id.menu_vaciar -> {

            }
        }
        return true
    }

    override fun onAsignaturaCreated(asignatura: Asignatura) {
        adaptador.addAsignatura(asignatura)
    }
}