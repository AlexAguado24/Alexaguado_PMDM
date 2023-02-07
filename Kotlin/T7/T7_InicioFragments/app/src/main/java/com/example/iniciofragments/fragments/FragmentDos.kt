package com.example.iniciofragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iniciofragments.databinding.FragmentDosBinding
import com.example.iniciofragments.databinding.FragmentUnoBinding

class FragmentDos: Fragment() {

    companion object{
        fun newInstance(nombre:String): FragmentDos{
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            val fragment = FragmentDos()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var binding: FragmentDosBinding
    private lateinit var nombreFragment: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        nombreFragment = this.arguments?.get("nombre").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDosBinding.inflate(inflater,container,false);

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.textoNombreF2.text = nombreFragment
    }

}