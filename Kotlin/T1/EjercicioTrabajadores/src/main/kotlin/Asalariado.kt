class Asalariado(nombre: String, apellido: String, dni: String) : Trabajador(nombre, apellido, dni) {

    var sueldo: Int = 0

    var numPagas: Int = 0

    var contratado: Boolean = false
        get() = contratado
        set(contratado) {
            field = contratado
        }

    constructor(nombre: String, apellido: String, dni: String, sueldo: Int, numPagas: Int) : this(
        nombre,
        apellido,
        dni
    ) {
        this.sueldo = sueldo
        this.numPagas = numPagas
        this.contratado = true
    }

    override fun mostrarDator() {
        super.mostrarDator()
        println("Sueldo : $sueldo")
        println("Numero de Pagas : $numPagas")
    }

    fun getnumPagas(): Int{
        return this.numPagas?: 0
    }
    fun setnumPagas(numPagas: Int){
        this.numPagas = numPagas
    }
}