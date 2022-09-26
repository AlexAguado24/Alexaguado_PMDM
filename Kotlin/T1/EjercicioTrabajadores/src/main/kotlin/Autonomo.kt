class Autonomo(nombre: String, apellido: String, dni: String) : Trabajador(nombre, apellido, dni) {

    var sueldo: Int = 0
    get() = field
    set(sueldo) { field = sueldo}
    var contratado: Boolean = false
        get() = field
        set(contratado) { field = contratado}

    constructor(nombre: String, apellido: String, dni: String, sueldo: Int) : this(nombre, apellido, dni) {
        this.sueldo = sueldo
        this.contratado = true
    }

    override fun mostrarDator() {
        super.mostrarDator()
        println("Sueldo $sueldo")
    }


}