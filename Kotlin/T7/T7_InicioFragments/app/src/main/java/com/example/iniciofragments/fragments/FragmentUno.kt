package com.example.iniciofragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iniciofragments.databinding.FragmentHeaderBinding
import com.example.iniciofragments.databinding.FragmentUnoBinding
import com.google.android.material.snackbar.Snackbar

class FragmentUno: Fragment() {

    private lateinit var binding: FragmentUnoBinding
    private lateinit var listener: OnFragmentNombreListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentNombreListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUnoBinding.inflate(inflater,container,false);

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonNombreF1.setOnClickListener {
            if (binding.editNombreF1.text.isEmpty()){
                Snackbar.make(binding.root, "No hay nombre a mostrar",Snackbar.LENGTH_SHORT).show()
            } else {
                //Snackbar.make(binding.root, binding.editNombreF1.text.toString(),Snackbar.LENGTH_SHORT).show()
                listener.onNombreSelected(binding.editNombreF1.text.toString())
            }
        }
    }

    interface OnFragmentNombreListener{
        fun onNombreSelected(nombre:String);
    }
}