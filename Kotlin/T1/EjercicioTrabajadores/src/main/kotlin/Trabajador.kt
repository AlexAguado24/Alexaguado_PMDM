open class Trabajador (var nombre: String, var apellido: String, val dni: String){


    open fun mostrarDator(){
        println("Nombre : $nombre")
        println("Apellido : $apellido")
        println("DNI : $dni")
    }

}