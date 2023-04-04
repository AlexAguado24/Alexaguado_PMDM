package com.example.jose_alejandro_aguado_merino

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.jose_alejandro_aguado_merino.adapter.AdapterProductos
import com.example.jose_alejandro_aguado_merino.databinding.FragmentSecondBinding
import com.example.jose_alejandro_aguado_merino.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var database: FirebaseDatabase
    private lateinit var arrayProductos: ArrayList<Producto>
    private lateinit var adaptadorProducto: AdapterProductos

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        database = FirebaseDatabase.getInstance("https://fir-ces-jaam-default-rtdb.firebaseio.com/")
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayProductos = ArrayList()
        adaptadorProducto = AdapterProductos(arrayProductos)
        binding.recyclerProductos.adapter = adaptadorProducto
        binding.recyclerProductos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

        var reference = database.getReference("productos")

        reference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (i in snapshot.children) {
                        var producto = i.getValue(Producto::class.java)
                        adaptadorProducto.addProducto(producto!!)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


        /*binding..setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}