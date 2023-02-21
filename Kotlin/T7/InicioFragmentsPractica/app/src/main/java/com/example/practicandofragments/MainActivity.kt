package com.example.practicandofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.practicandofragments.databinding.ActivityMainBinding
import com.example.practicandofragments.fragments.FragmentDos
import com.example.practicandofragments.fragments.FragmentUno
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener, FragmentUno.OnNombreFragmentListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fragmentUno.setOnClickListener(this)
        binding.fragmentDos.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.fragmentUno.id -> {
                val fm = supportFragmentManager;
                val ft = fm.beginTransaction();
                ft.replace(binding.sitioFragments.id,FragmentUno())
                ft.commit();
            }
            binding.fragmentDos.id -> {
                val fm = supportFragmentManager;
                val ft = fm.beginTransaction();
                ft.replace(binding.sitioFragments.id, FragmentDos())
                ft.commit();
            }
        }
    }

    override fun onNombreSelected(nombre: String) {
        FragmentDos.newInstance(nombre)
    }
}