package model

open abstract class Trabajador (protected var nombre: String, protected var apellido: String, protected val dni: String){


    open fun mostrarDator(){
        println("Nombre : $nombre")
        println("Apellido : $apellido")
        println("DNI : $dni")
    }

    fun getDNI(): String{
        return dni
    }

}