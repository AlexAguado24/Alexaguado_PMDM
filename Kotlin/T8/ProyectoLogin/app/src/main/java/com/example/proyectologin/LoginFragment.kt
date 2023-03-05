package com.example.proyectologin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.proyectologin.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private lateinit var auth: FirebaseAuth

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //son iguales
        //auth = FirebaseAuth.getInstance()
        auth = Firebase.auth
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_RegisterFragment);
        }
        Glide.with(requireContext())
            .load("https://ps.w.org/login-customizer/assets/icon-256x256.png?rev=2455454")
            .placeholder(R.drawable.login).into(binding.imagenLogin)

        binding.buttonLogin.setOnClickListener {
            //comprobar en base de datos
                //True isSuccesfull
            if (binding.editNombre.text.isNotEmpty() && binding.editPassword.text.isNotEmpty()) {
                auth.signInWithEmailAndPassword("","")
                    .addOnCompleteListener{
                        if (it.isSuccessful) {
                            val bundle = Bundle()
                            bundle.putString("nombre",binding.editNombre.text.toString())
                            bundle.putString("nombre",binding.editPassword.text.toString())


                        } else {

                        }
                    }
            }else {

            }

        }
        binding.buttonRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_RegisterFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}