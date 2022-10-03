package model

open abstract class Persona (var nombre: String, var apellido: String, val dni: String){

    open fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
    }
}