package com.example.repaso_bbdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repaso_bbdd.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private var uid : String? = null
    private var usuario : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_second)

        usuario = intent.extras!!.getString("usuario")
        uid = intent.extras!!.getString("uid")

        

    }
}