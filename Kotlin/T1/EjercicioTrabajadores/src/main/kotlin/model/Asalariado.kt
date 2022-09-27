package model

class Asalariado(nombre: String, apellido: String, dni: String, var sueldo: Int, var numPagas: Int)
    : Trabajador(nombre, apellido, dni) {

    var contratado: Boolean = false

    override fun mostrarDator() {
        super.mostrarDator()
        println("Salario anual $sueldo")
        println("Salario mensual ${sueldo/numPagas}")
        println("Numero Pagas $numPagas")
    }
}