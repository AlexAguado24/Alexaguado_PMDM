package com.example.dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.dialogos.databinding.ActivityMainBinding
import com.example.dialogos.dialogs.DialogoConfirmacion

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.botonConfirmacion.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonConfirmacion.id -> {
                //saltar el cuadro de dialogo
                //show() parte del cuadro de DialogFragment
                val dialogoConfirmacion = DialogoConfirmacion()
                dialogoConfirmacion.show(supportFragmentManager,"")

            }
        }
    }



}