package com.example.practicandofragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.practicandofragments.databinding.FragmentUnoBinding
import com.google.android.material.snackbar.Snackbar

class FragmentUno: Fragment() {

    private lateinit var binding: FragmentUnoBinding;
    private lateinit var listener: OnNombreFragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnNombreFragmentListener;
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUnoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonNombreF1.setOnClickListener{
            //Toast.makeText(requireContext(),binding.editNombreF1.text.toString(),Toast.LENGTH_SHORT).show()
            if (binding.editNombreF1.text.isNotEmpty()) {
                //Snackbar.make(it,binding.editNombreF1.text.toString(),Snackbar.LENGTH_SHORT).show()
                listener.onNombreSelected(binding.editNombreF1.text.toString())
            } else {
                Snackbar.make(it,"No hay nombre",Snackbar.LENGTH_SHORT).show()
            }

        }
    }

    interface OnNombreFragmentListener{
        fun onNombreSelected(nombre:String);
    }
}