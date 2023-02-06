package com.example.iniciofragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.iniciofragments.databinding.FragmentHeaderBinding
import com.example.iniciofragments.dialog.DialogoFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.combine

class FragmentHeader: Fragment() {

    private lateinit var binding: FragmentHeaderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeaderBinding.inflate(inflater,container,false);
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonHeader.setOnClickListener {
            crearDialogoAyuda().show();
        }
    }

    fun crearDialogoAyuda(): AlertDialog{
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setMessage("Primera aplicacion con fragments")
        return builder.create();
    }
}