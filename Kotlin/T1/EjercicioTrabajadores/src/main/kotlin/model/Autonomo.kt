package model

class Autonomo(nombre: String, apellido: String, dni: String, var sueldo: Int)
    : Trabajador(nombre, apellido, dni) {

    var contratado: Boolean = false

    override fun mostrarDator() {
        super.mostrarDator()
        println("Sueldo $sueldo")
    }


}