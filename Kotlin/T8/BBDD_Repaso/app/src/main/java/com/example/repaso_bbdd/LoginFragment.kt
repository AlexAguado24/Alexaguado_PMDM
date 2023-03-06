package com.example.repaso_bbdd

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.repaso_bbdd.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private lateinit var auth: FirebaseAuth;
    private lateinit var database: FirebaseDatabase
    private var correo: String? = null
    private var pasword: String? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        database = Firebase.database("https://fir-ces-jaam-default-rtdb.firebaseio.com/")
        auth = FirebaseAuth.getInstance();
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editUsuario.setText(arguments?.getString("correo"))
        binding.editContrasenia.setText(arguments?.getString("password"))
        binding.buttonLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.editUsuario.text.toString(),
                binding.editContrasenia.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        var bundle = Bundle()
                        bundle.getString("correo", binding.editUsuario.text.toString())
                        bundle.getString("uid", auth.currentUser!!.uid)
                        findNavController().navigate(
                            R.id.action_FirstFragment_to_secondActivity,
                            bundle
                        )
                    } else {
                        Snackbar.make(binding.root, "Error en el login", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }
        }

        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}