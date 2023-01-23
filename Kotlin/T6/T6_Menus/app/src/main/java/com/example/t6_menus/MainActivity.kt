package com.example.t6_menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.t6_menus.adapters.AdaptadorPrueba
import com.example.t6_menus.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private lateinit var adaptadorPrueba: AdaptadorPrueba

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        adaptadorPrueba = AdaptadorPrueba(this,ArrayList<String>())
        binding.recyclerPrueba.adapter = adaptadorPrueba
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_prueba,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var texto:String =""

        when(item.itemId){
            R.id.menu_op1 -> {
                texto = "Elemento 1"
                Snackbar.make(binding.root,"Pulsado item 1",Snackbar.LENGTH_SHORT).show()
            }
            R.id.menu_op2 -> {
                texto = "Elemento 2"
                Snackbar.make(binding.root,"Pulsado item 2",Snackbar.LENGTH_SHORT).show()
            }
            R.id.menu_op1_1 -> {
                texto = "Elemento 1.1"
                Snackbar.make(binding.root,"Pulsado item 1.1",Snackbar.LENGTH_SHORT).show()
            }
            R.id.menu_op1_2 -> {
                texto = "Elemento 1.2"
                Snackbar.make(binding.root,"Pulsado item 1.2",Snackbar.LENGTH_SHORT).show()
            }
            R.id.menu_agregar ->{

            }
            else -> {
                texto = "Elemento no identificado"

            }
        }
        Snackbar.make(binding.root,texto,Snackbar.LENGTH_SHORT).show()
        return true
    }

}