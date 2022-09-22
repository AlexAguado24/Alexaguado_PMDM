class Asalariado(nombre: String, apellido: String, dni: String) : Trabajador(nombre, apellido, dni) {

    var sueldo: Int = 0
    set(sueldo) {
        field = sueldo
    }
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

    fun getnumPagas(): Int{
        return this.numPagas?: 0
    }
    fun setnumPagas(numPagas: Int){
        this.numPagas = numPagas
    }
}