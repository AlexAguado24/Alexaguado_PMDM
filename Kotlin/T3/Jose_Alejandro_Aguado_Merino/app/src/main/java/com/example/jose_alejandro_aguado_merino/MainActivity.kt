package com.example.jose_alejandro_aguado_merino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.jose_alejandro_aguado_merino.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.botonComprobar.setOnClickListener(this)
        binding.botonModelos.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id) {
            R.id.boton_comprobar->{
                var intent = Intent(applicationContext, ComprobarActivity::class.java);
                startActivity(intent);
            }
            R.id.boton_modelos->{
                var intent = Intent(applicationContext, ModelosActivity::class.java);
                startActivity(intent);
            }
        }
    }


}