package com.example.dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.dialogos.databinding.ActivityMainBinding
import com.example.dialogos.dialogs.DialogoConfirmacion
import com.example.dialogos.dialogs.DialogoLista
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener,
    DialogoConfirmacion.OnDialogoConfirmListener, DialogoLista.OnListaListener {

    private lateinit var binding: ActivityMainBinding
    private var dialogoConfirm: DialogoConfirmacion;

    init {
        dialogoConfirm = DialogoConfirmacion()
        dialogoConfirm.funcionNula = { elemento ->
            if (elemento) {
                Snackbar.make(binding.root, "Seleccionado true", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(binding.root, "Seleccionado false", Snackbar.LENGTH_SHORT).show()
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.botonConfirmacion.setOnClickListener(this)
        binding.botonLista.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            binding.botonConfirmacion.id -> {
                //saltar el cuadro de dialogo
                //show() parte del cuadro de DialogFragment
                val dialogoConfirmacion = DialogoConfirmacion()
                dialogoConfirmacion.show(supportFragmentManager, "")
            }
            binding.botonLista.id -> {
                DialogoLista().show(supportFragmentManager, "")
            }
        }
    }

    override fun onDielogoSelected(seleccionado: Boolean) {
        if (seleccionado) {
            Snackbar.make(binding.root, "Seleccionado true", Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(binding.root, "Seleccionado false", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onElementoListaSelected(elemento: String) {
        binding.textoLista.text = elemento
    }


}