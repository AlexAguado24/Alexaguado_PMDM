class Autonomo(nombre: String, apellido: String, dni: String) : Trabajador(nombre, apellido, dni) {

    var sueldo: Int = 0
    var contratado: Boolean = false

    constructor(nombre: String, apellido: String, dni: String, sueldo: Int) : this(nombre, apellido, dni) {
        this.sueldo = sueldo
        this.contratado = true
    }

    override fun mostrarDator() {
        super.mostrarDator()
        println("Sueldo $sueldo")
    }


}