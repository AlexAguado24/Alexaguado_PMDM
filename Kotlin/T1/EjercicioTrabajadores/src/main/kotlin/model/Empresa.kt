package model

import java.util.ArrayList
class Empresa (){

    var listaTrabajadores: ArrayList<Trabajador>?;
    var trabajadorADespedir: Trabajador? = null
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
    fun despedirTrabajador(dni: String) {
        listaTrabajadores!!.forEach { persona ->
            if (dni.equals(persona.getDNI()) && persona is Jefe) {
                var dni_empleado: String? = null
                println("Introduzca DNI del trabajador:")
                dni_empleado = readLine()?.toString()
                listaTrabajadores!!.forEach { trabajador ->
                    if (dni_empleado == trabajador.getDNI()) {
                        trabajadorADespedir = trabajador
                        println("Trabajador despedido")
                    } else {
                        println("El trabajador no encontrado")
                    }
                }
            } else {
                println("Solo un jefe puede despedir")
            }
        }
        listaTrabajadores!!.remove(trabajadorADespedir)
    }
}

