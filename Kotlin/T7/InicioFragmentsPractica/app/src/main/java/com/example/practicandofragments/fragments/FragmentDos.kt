package com.example.practicandofragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practicandofragments.databinding.FragmentDosBinding
import com.example.practicandofragments.databinding.FragmentUnoBinding

class FragmentDos: Fragment() {

    private lateinit var binding: FragmentDosBinding;
    private lateinit var nombreF1: String;

    companion object{
        fun newInstance(nombre:String): FragmentDos{
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            val fragment = FragmentDos()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        nombreF1 = this.arguments?.getString("nombre") ?: "Defecto"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.textNombreF2.text = nombreF1
    }
}