package herencia

import java.sql.DriverManager.println

class Alumno(nombre: String, apellido: String, dni: String, edad: Int) : Persona(nombre, apellido, dni, edad) {


    var matricula: String? = null

    constructor(nombre: String, apellido: String, dni: String, edad: Int, matricula: String) : this(
        nombre,
        apellido,
        dni,
        edad
    ) {
        this.matricula = matricula
    }

    init {
        if(this.edad > 18) println("Procedemos a tu matricula")
        else println("No te puedes matricular aqui")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Matricula $matricula")
    }
}