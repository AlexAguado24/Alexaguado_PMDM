package com.example.t3_spinner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.t3_spinner.adaptadores.AdaptadorPersonalizado
import com.example.t3_spinner.databinding.ActivityMainBinding
import com.example.t3_spinner.modelo.Pais
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityMainBinding;
    lateinit var arraySpinner: ArrayList<Pais>;
    lateinit var adaptadorSencillo: ArrayAdapter<CharSequence>;
    lateinit var adaptadorPersonalizado: AdaptadorPersonalizado;
    lateinit var pais: Pais

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos();
        //rellenarSpinnerPersonalizado();
        acciones();
    }

    private fun acciones() {
        /*binding.spinnerSimple.setOnItemClickListener { adapterView, view, i, l ->
            Snackbar.make(binding.spinnerSimple,i.toString(),Snackbar.LENGTH_SHORT).show()
        }*/
        binding.spinnerSimple.onItemSelectedListener = this
        binding.spinnerComplejo.onItemSelectedListener = this
        binding.botonAgregar.setOnClickListener{
            var pais: Pais = Pais("Argentina", R.drawable.esc_argentina,2,"Messi")
            //agregar un elemento desde la clase
            adaptadorPersonalizado.agregarPais(pais)
            //agregar un elemento a la lista desde la clase
            /*arraySpinner.add(pais)
            adaptadorPersonalizado.notifyDataSetChanged()*/
        }
        binding.botonDetalle.setOnClickListener {
            var intent: Intent = Intent(applicationContext,DetailActivity::class.java)
            var bundle = Bundle();
            //1ª ejemplo de como sacar datos de un elemento para enviar a otra pantalla
            // var equipoSeleccionado = binding.spinnerComplejo.selectedItem
            //2º creo pais como variable de clase y saco datos
            /*bundle.putInt("imagen", pais.imagen)
            bundle.putString("nombre", pais.nombre)
            bundle.putString("estrella", pais.estrella)
            bundle.putInt("titulos", pais.numeroTitulos)*/
            bundle.putSerializable("equipo",pais)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun asociarDatos() {
        binding.spinnerSimple.adapter = adaptadorSencillo;
        binding.spinnerComplejo.adapter = adaptadorPersonalizado
    }

    private fun instancias() {
        arraySpinner = ArrayList()
        /*adaptadorSencillo =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, arraySpinner)*/
        adaptadorSencillo = ArrayAdapter.createFromResource(applicationContext,
            R.array.paises,android.R.layout.simple_spinner_item)
        //adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //lista + xml + context --> adapter
        //primero relleno la lista y una ves rellena se la doy al adaptador para que aparezcan los elementos actualizados
        rellenarSpinnerPersonalizado();
        adaptadorPersonalizado = AdaptadorPersonalizado(arraySpinner, this)

    }

    private fun rellenarSpinnerPersonalizado() {
        // para rellenar el spinner hace falta una lista de elementos
        //lista --> array o arraylist o recurso del sistema
        arraySpinner.add(Pais("España",R.drawable.esc_espania,1,"Pedri"))
        arraySpinner.add(Pais("Brasil",R.drawable.es_brasil,5,"Neymar"))
        arraySpinner.add(Pais("Alemania",R.drawable.esc_alemania,4,"Muller"))
        arraySpinner.add(Pais("Francia",R.drawable.esc_france,2,"Mbappe"))
        arraySpinner.add(Pais("Qatar",R.drawable.esc_qatar,0,"Desconocido"))
        //adaptadorPersonalizado.notifyDataSetChanged()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p0!!.id){
            R.id.spinner_simple->{
                pais = adaptadorPersonalizado.getItem(p2) as Pais
                //Log.v("testSpinner",pais.nombre)
                binding.imagenEscudo.setImageResource(pais.imagen)
            }
            R.id.spinner_complejo->{
                pais = adaptadorPersonalizado.getItem(p2) as Pais
                //Log.v("testSpinner",pais.nombre)
                binding.imagenEscudo.setImageResource(pais.imagen)
            }
        }
        //Snackbar.make(p1!!,p2.toString(),Snackbar.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}