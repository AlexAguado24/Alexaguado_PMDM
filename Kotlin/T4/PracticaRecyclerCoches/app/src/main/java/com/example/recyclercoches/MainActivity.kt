package com.example.recyclercoches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclercoches.databinding.ActivityMainBinding
import com.example.recyclercoches.model.Coche

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaCoches: ArrayList<Coche>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}