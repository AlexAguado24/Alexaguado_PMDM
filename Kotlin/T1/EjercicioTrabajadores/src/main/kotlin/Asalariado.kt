class Asalariado(nombre: String, apellido: String, dni: String) : Trabajador(nombre, apellido, dni) {

    var sueldo: Int = 0
    var numPagas: Int = 0
    var contratado: Boolean = false

    constructor(nombre: String, apellido: String, dni: String, sueldo: Int, numPagas: Int, contratado: Boolean) : this(
        nombre,
        apellido,
        dni
    ) {
        this.sueldo = sueldo
        this.numPagas = numPagas
        this.contratado = contratado
    }

    override fun mostrarDator() {
        super.mostrarDator()
        println("Sueldo $sueldo")
        println("Numero de Pagas $numPagas")
        println("Contratado $contratado")
    }
}