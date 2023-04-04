package com.example.repaso_bbdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repaso_bbdd.adapter.AdapterProducto
import com.example.repaso_bbdd.databinding.ActivitySecondBinding
import com.example.repaso_bbdd.model.Producto
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class SecondActivity : AppCompatActivity() {

    private lateinit var fDataBase: FirebaseDatabase
    private lateinit var binding: ActivitySecondBinding
    private lateinit var arrayProductos : ArrayList<Producto>
    private lateinit var adapterProducto: AdapterProducto
    private var uid: String? = null
    private var usuario: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        arrayProductos = ArrayList()
        fDataBase =
            FirebaseDatabase.getInstance("https://fir-ces-jaam-default-rtdb.firebaseio.com/")
        setContentView(binding.root)
        initGUI();
        configurarAdapter()
        binding.botonGuardar.setOnClickListener {
            Snackbar.make(binding.root, uid!!, Snackbar.LENGTH_SHORT)
                .show()
            var nombreProducto = binding.editNombre.text.toString()
            var valorProducto = binding.editValor.text.toString().toInt()
            val referencia = fDataBase.getReference("users")
                .child(uid!!)
                .child("productos_fav")
                .child(nombreProducto)

            referencia.child("nombre").setValue(nombreProducto)
            referencia.child("valor").setValue(valorProducto)


        }
        binding.botonResuperar.setOnClickListener {
            arrayProductos.clear()
            fDataBase.getReference("users")
                .child(uid!!)
                .child("productos_fav")
                .addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            for (i in snapshot.children){
                                val producto = i.getValue(Producto::class.java)
                                /*Log.v("producto",producto!!.valor.toString())*/
                                adapterProducto.addProducto(producto!!)
                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
        }

    }

    fun configurarAdapter(){
        adapterProducto = AdapterProducto(this,arrayProductos)
        binding.recyclerProductos.adapter = adapterProducto
        binding.recyclerProductos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    }


    private fun initGUI() {
        usuario = intent.extras!!.getString("usuario")
        uid = intent.extras!!.getString("uid")
        fDataBase.getReference("usuarios")
            .child(uid.toString())
            .child("nombre")
            .setValue(usuario)
    }
}

