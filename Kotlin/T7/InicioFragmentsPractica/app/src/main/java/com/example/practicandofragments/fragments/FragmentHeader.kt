package com.example.practicandofragments.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.practicandofragments.databinding.FragmentHeaderBinding
import com.example.practicandofragments.dialogs.DialogoAyuda
import com.google.android.material.snackbar.Snackbar

class FragmentHeader: Fragment() {

    private lateinit var binding: FragmentHeaderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHeaderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonHeader.setOnClickListener {
            crearDialogoAyuda().show()
            //Snackbar.make(binding.root,"Primera app con fragments",Snackbar.LENGTH_SHORT).show();
        }
    }

    fun crearDialogoAyuda(): Dialog{
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setMessage("Primera aplicacion con fragment")
        return builder.create()
    }

}