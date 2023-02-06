package com.example.iniciofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.iniciofragments.databinding.ActivityMainBinding
import com.example.iniciofragments.fragments.FragmentUno

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonUno.setOnClickListener(this)
        binding.botonDos.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.botonUno.id ->{
                val fm = supportFragmentManager;
                val ft = fm.beginTransaction();
                ft.replace(binding.sitioFragments.id,FragmentUno())
                ft.commit();
            }
            binding.botonDos.id ->{
                val fm = supportFragmentManager;
                val ft = fm.beginTransaction();
                ft.replace(binding.sitioFragments.id,FragmentUno())
                ft.commit();
            }
        }
    }


}