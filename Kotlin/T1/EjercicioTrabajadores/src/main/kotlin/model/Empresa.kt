package model

import java.util.ArrayList
class Empresa {

    var listaTrabajadores: ArrayList<Trabajador>?;

    init {
        listaTrabajadores = ArrayList()
    }

    fun añadirTrabajador(trabajador: Trabajador) {
            var existe: Boolean = false
            listaTrabajadores!!.forEach { item ->
                if (item.getDNI().equals(trabajador.getDNI())) {
                    println("El trabajador que has introducido ya existe")
                    existe = true
                }
            }
            if (!existe) {
                listaTrabajadores!!.add(trabajador)
            }
    }

    fun existeJefe(): Boolean {
        var existe: Boolean = false
        listaTrabajadores!!.forEach { item ->
            if (item is Jefe) {
                existe = true
            }
        }
        if (!existe) {
            existe = false
        }
        return existe
    }

    fun listarTrabajadores(tipo: String){
        listaTrabajadores!!.forEach {
            persona ->
            when(tipo){
                "Asalariado" ->{
                    if (persona is Asalariado){
                        println("Asalariado: ")
                        persona.mostrarDator()
                    }
                }
                "Autonomo" -> {
                    println("Autonomo: ")
                    if (persona::class.simpleName?.toLowerCase() == tipo.toLowerCase()){
                        /*(persona as Asalariado) <- Forma de castear en kotlin */
                        persona.mostrarDator()
                    }
                }
                else ->{
                    persona.mostrarDator();
                    println()
                }
            }
        }
    }

    fun listarDatosDelTrabajador(dni:String){
        var existe: Boolean = false
        listaTrabajadores!!.forEach {
                trabajador ->
                if (trabajador.getDNI() == dni){
                    trabajador.mostrarDator()
                    existe = true
                }
        }
        if (!existe) {
            println("El trabajador indicado no existe")
        }
    }

    fun despedirTrabajador(dniJefe: String, dniTrabajador: String) {
        var existe: Boolean = false
        var existeJefe : Boolean = false
        listaTrabajadores!!.forEach { item ->
            if (item.getDNI() == dniJefe) {
                existeJefe = true
                listaTrabajadores!!.forEachIndexed{
                    index, trabajador ->
                    if (trabajador.getDNI() == (dniTrabajador)){
                        listaTrabajadores!!.remove(trabajador)
                    }
                }
                /*listaTrabajadores!!.forEach { trabajador ->
                    if (trabajador.getDNI().equals(dniTrabajador)) {
                        listaTrabajadores!!.remove(trabajador)
                        existe = true
                    }
                }*/
            }
        }
        if (!existe || !existeJefe) {
            println("El trabajador o jefe que buscas no estan en la empresa")
        }
    }

}

