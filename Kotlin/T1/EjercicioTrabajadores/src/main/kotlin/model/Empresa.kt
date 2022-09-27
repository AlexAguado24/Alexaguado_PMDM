package model

import java.util.ArrayList
class Empresa {

    var listaTrabajadores: ArrayList<Trabajador>?;

    init {
        listaTrabajadores = ArrayList()
    }

    fun añadirTrabajador(trabajador: Trabajador) {
        var existe: Boolean = false
        listaTrabajadores?.forEach {  }
        /*listaTrabajadores!!.forEachIndexed { index, trabajador ->
            //todo preguntar como comparar atributos entre objetos para saber si coinciden
            if (trabajador.equals(trabajador)){
                println("El trabajador ya existe")
                existe = true
            }
            if (trabajador is Jefe){
                println("No puede haber mas de un jefe en la empresa")
                existe = true
            }
        }*/
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

