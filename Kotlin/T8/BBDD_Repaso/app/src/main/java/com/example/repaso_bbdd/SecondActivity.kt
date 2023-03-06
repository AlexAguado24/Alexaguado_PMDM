package com.example.repaso_bbdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repaso_bbdd.databinding.ActivitySecondBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var fDataBase : FirebaseDatabase
    private var uid : String? = null
    private var usuario : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        fDataBase = FirebaseDatabase.getInstance("https://fir-ces-jaam-default-rtdb.firebaseio.com/");
        setContentView(binding.root)

        usuario = intent.extras!!.getString("usuario")
        uid = intent.extras!!.getString("uid")

        binding.botonGuardar.setOnClickListener {
            var referencia = fDataBase.getReference("Usuarios")
            referencia.child(uid.toString()).child("nombre").setValue(usuario);
        }

    }
}