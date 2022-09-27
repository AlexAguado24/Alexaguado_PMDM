package model

import java.util.ArrayList
class Empresa {

    var listaTrabajadores: ArrayList<Trabajador>?;

    init {
        listaTrabajadores = ArrayList()
    }
    fun añadirTrabajador(trabajador: Trabajador){
        listaTrabajadores!!.add(trabajador)
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

}

