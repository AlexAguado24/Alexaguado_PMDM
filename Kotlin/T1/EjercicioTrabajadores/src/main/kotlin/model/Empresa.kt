package model

import java.util.ArrayList
class Empresa {

    var listaTrabajadores: ArrayList<Trabajador>?;

    init {
        listaTrabajadores = ArrayList()
    }

    fun añadirTrabajador(trabajador: Trabajador) {
        var existe: Boolean = false
        var existeJefe : Boolean = false
        listaTrabajadores!!.forEachIndexed { index, item ->
            if (trabajador.getDNI().equals(item.getDNI())){
                println("El trabajador ya existe")
                existe = true
            }
            if ( item is Jefe ){
                println("No puede haber mas de un jefe en la empresa")
                existeJefe = true
            }
        }
        if (!existe){
            listaTrabajadores!!.add(trabajador)
        }
    }

    fun listarTrabajadores(tipo: String){
        listaTrabajadores!!.forEach {
            persona ->
            when(tipo){
                "Asalariado" ->{
                    if (persona is Asalariado){
                        persona.mostrarDator()
                    }
                }
                "Autonomo" -> {
                    if (persona::class.simpleName?.toLowerCase() == tipo.toLowerCase()){
                        /*(persona as Asalariado) <- Forma de castear en kotlin */
                        persona.mostrarDator()
                    }
                }
                else ->{
                    persona.mostrarDator();
                }
            }
        }
    }

    fun listarDatosDelTrabajador(dni:String){
        //todo preguntar como comparar el dni de cada trabajador para luego listarlo
    }

}

