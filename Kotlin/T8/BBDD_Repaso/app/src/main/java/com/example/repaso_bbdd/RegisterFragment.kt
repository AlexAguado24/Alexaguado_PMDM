package com.example.repaso_bbdd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.repaso_bbdd.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = FirebaseAuth.getInstance();
        database = Firebase.database("https://fir-ces-jaam-default-rtdb.firebaseio.com/")
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonRegistrar.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Snackbar.make(
                            binding.root,
                            "Cuenta creada con id " + auth.currentUser!!.uid,
                            Snackbar.LENGTH_SHORT
                        ).show()
                        var referencia = database.getReference("Usuarios");

                        referencia.child(binding.editNombre.text.toString()).child("correo")
                            .setValue(binding.editCorreo.text.toString())
                        referencia.child(binding.editNombre.text.toString()).child("direccion")
                            .setValue(binding.editDireccion.text.toString())
                        referencia.child(binding.editNombre.text.toString()).child("edad")
                            .setValue(binding.editEdad.text.toString())
                        var bundle = Bundle()
                        bundle.putString("correo", binding.editCorreo.text.toString())
                        bundle.putString("password", binding.editPass.text.toString())
                        findNavController().navigate(
                            R.id.action_SecondFragment_to_FirstFragment,
                            bundle
                        )
                    } else {
                        Snackbar.make(binding.root, "Error en creacion", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}