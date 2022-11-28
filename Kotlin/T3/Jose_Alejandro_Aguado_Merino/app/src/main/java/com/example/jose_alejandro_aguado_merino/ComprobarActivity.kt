package com.example.jose_alejandro_aguado_merino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.jose_alejandro_aguado_merino.databinding.ActivityComprobarBinding
import com.example.jose_alejandro_aguado_merino.databinding.ActivityModelosBinding
import com.google.android.material.snackbar.Snackbar

class ComprobarActivity : AppCompatActivity() {
    lateinit var binding: ActivityComprobarBinding
    lateinit var adaptadorSencillo: ArrayAdapter<CharSequence>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityComprobarBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        instancias();

        binding.spinnerCombustible.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var adaptador = adaptadorSencillo.getItem(view!!.id) as String
                if (adaptador.equals("Hibrido")) {
                    binding.editAnio.setText("2018")
                    binding.editAnio.isEnabled = false
                    binding.imagenEtiqueta.setImageResource(R.drawable.etiquetaeco)
                } else if (adaptador.equals("Electrico")) {
                    binding.editAnio.setText("2020")
                    binding.editAnio.isEnabled = false
                    binding.imagenEtiqueta.setImageResource(R.drawable.etiqueta0)
                } else if (adaptador.equals("Gasolina")) {
                    if (binding.editAnio.text.toString().toInt() >= 2006) {
                        binding.imagenEtiqueta.setImageResource(R.drawable.etiquetac)
                    }else if (binding.editAnio.text.toString().toInt() >= 2000 || binding.editAnio.text.toString().toInt() <= 2005) {
                        binding.imagenEtiqueta.setImageResource(R.drawable.etiquetab)
                    } else if (binding.editAnio.text.toString().toInt() < 2000 ) {
                        binding.imagenEtiqueta.setImageResource(R.drawable.etiquetaa)
                    }
                } else if (adaptador.equals("Diesel")) {
                    if (binding.editAnio.text.toString().toInt() >= 2015) {
                        binding.imagenEtiqueta.setImageResource(R.drawable.etiquetac)
                    }else if (binding.editAnio.text.toString().toInt() >= 2004 || binding.editAnio.text.toString().toInt() <= 2014) {
                        binding.imagenEtiqueta.setImageResource(R.drawable.etiquetab)
                    } else if (binding.editAnio.text.toString().toInt() < 2004 ) {
                        binding.imagenEtiqueta.setImageResource(R.drawable.etiquetaa)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.botonComprobar.setOnClickListener {
            if (binding.editMatricula.text.isEmpty() || binding.editAnio.text.isEmpty()){
                Snackbar.make(binding.botonComprobar, "Faltan Datos", Snackbar.LENGTH_SHORT).show()
            } else {
                binding.imagenEtiqueta.visibility
            }
        }

    }

    private fun instancias() {
        adaptadorSencillo = ArrayAdapter.createFromResource(applicationContext,
            R.array.Combustible,android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCombustible.adapter = adaptadorSencillo
    }
}