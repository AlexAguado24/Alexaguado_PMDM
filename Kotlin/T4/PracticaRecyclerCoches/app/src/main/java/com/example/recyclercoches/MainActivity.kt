package com.example.recyclercoches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.recyclercoches.adapter.AdaptadorCoches
import com.example.recyclercoches.databinding.ActivityMainBinding
import com.example.recyclercoches.model.Coche

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaCoches: ArrayList<Coche>;
    private lateinit var adaptadorCoches: AdaptadorCoches;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias();
        configurarAdaptador()
    }

    private fun configurarAdaptador() {
        binding.listaRecycler.adapter = adaptadorCoches
        binding.listaRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        //binding.listaRecycler.layoutManager = GridLayoutManager(this,2)
    }

    private fun instancias() {
        listaCoches = ArrayList();
        listaCoches.add(Coche("mercedes","amg",1000,50000,R.drawable.amggt));
        listaCoches.add(Coche("bentley","continental",800,60000,R.drawable.continental));
        listaCoches.add(Coche("jaguar","ftype",1200,65000,R.drawable.ftype));
        listaCoches.add(Coche("ford","gt40",900,45000,R.drawable.gt40));
        listaCoches.add(Coche("nissan","gtr",1250,55000,R.drawable.gtr));
        listaCoches.add(Coche("pagani","huayra",2000,70000,R.drawable.huayra));
        listaCoches.add(Coche("lexus","lc",850,30000,R.drawable.lc));
        listaCoches.add(Coche("ferrari","laferrari",25000,100000,R.drawable.leferrari));
        listaCoches.add(Coche("noble","m600",1500,80000,R.drawable.mc600));
        listaCoches.add(Coche("toyota","supra",1300,59000,R.drawable.supra));
        listaCoches.add(Coche("porche","taycan",1400,68000,R.drawable.taycan));
        adaptadorCoches = AdaptadorCoches(listaCoches,this)
    }
}