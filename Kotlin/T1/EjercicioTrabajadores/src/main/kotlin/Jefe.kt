class Jefe(nombre: String, apellido: String, dni: String) : Trabajador(nombre, apellido, dni) {

    var acciones: Int? = 0
    get() = acciones
    set(acciones) {
        field = acciones
    }
    var beneficios: Int? = 0
        get() = acciones
        set(beneficios) {
            field = beneficios
        }
    constructor(nombre: String, apellido: String, dni: String, acciones: Int, beneficios: Int) : this(nombre, apellido, dni){
        this.acciones = acciones
        this.beneficios = beneficios
        despedir(nombre)
    }

    override fun mostrarDator() {
        super.mostrarDator()
        println("Acciones : $acciones")
        println("Beneficios : $beneficios")
    }

    fun despedir (nombre: String): Boolean{

        return false
    }
}