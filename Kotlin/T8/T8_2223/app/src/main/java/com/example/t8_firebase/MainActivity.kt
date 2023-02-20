package com.example.t8_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.t8_firebase.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth;
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance();

        setContentView(binding.root)

        binding.botonCrear.setOnClickListener {
            auth.createUserWithEmailAndPassword("alex@gmail.com","Admin1234#")
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        Log.v("firebase_ejemplo","usuario creado con exito")
                    } else {
                        Log.v("firebase_ejemplo","error en la creacion del usuario")

                    }
                }
        }
        binding.botonLogin.setOnClickListener {
            auth.signInWithEmailAndPassword("alex@gmail.com","Admin1234#")
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Log.v("firebase_ejemplo","usuario logeado con uid: "+auth.currentUser!!.uid)
                    } else {
                        Log.v("firebase_ejemplo","error en el login del usuario")

                    }
                }
        }

    }
}