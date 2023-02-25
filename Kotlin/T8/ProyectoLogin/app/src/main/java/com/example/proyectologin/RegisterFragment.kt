package com.example.proyectologin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.proyectologin.databinding.FragmentRegisterBinding
import com.example.proyectologin.model.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuthActionCodeException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private var usuario: Usuario? = null
    private var edad = 0;
    private lateinit var adapterEdad: ArrayAdapter<CharSequence>
    private lateinit var database: Firebase;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapterEdad = ArrayAdapter.createFromResource(
            context,
            R.array.array_edades,
            android.R.layout.simple_spinner_item
        );
        //database = Firebase.database("https://fir-ces-jaam-default-rtdb.firebaseio.com/")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_RegisterFragment_to_LoginFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        adapterEdad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerEdad.adapter = adapterEdad;
        binding.spinnerEdad.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                edad = position + 18
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    override fun onResume() {
        super.onResume()
        binding.botonRegistrar.setOnClickListener {
            /*val ref = database.getReference("Usuario")
        ref.setValue(
            Usuario(
                binding.editNombre.text.toString(),
                binding.editCorreo.text.toString(),
                binding.editPassword.text.toString(),
                edad.toString(),
                binding.editDireccion.text.toString()
            )
        )*/
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}