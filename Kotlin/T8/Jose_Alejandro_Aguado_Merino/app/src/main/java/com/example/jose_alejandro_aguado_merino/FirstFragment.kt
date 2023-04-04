package com.example.jose_alejandro_aguado_merino

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jose_alejandro_aguado_merino.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private var contador = 0

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://fir-ces-jaam-default-rtdb.firebaseio.com/")
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var reference = database.getReference("usuarios")
            .child(auth.currentUser!!.uid)
            .child("logoncount")

        reference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (i in snapshot.children) {
                        contador = i.value.toString().toInt()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        binding.botonLogin.setOnClickListener {
            if (binding.editUsuario.text.isNotEmpty() && binding.editPass.text.isNotEmpty()){
                auth.signInWithEmailAndPassword(binding.editUsuario.text.toString(),binding.editPass.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            reference.setValue(contador++)
                            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                        }else {
                            Snackbar.make(binding.root,"Alguno de los datos esta mal",Snackbar.LENGTH_SHORT).show()
                        }
                    }

            } else {
                Snackbar.make(binding.root,"Alguno de los campos esta vacio",Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}