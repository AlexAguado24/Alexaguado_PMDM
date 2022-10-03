package model

class Medico(nombre: String, apellido: String, dni: String, private var numColegiado: Int, private var especialidad: String)
    : Persona(nombre, apellido, dni) {

    lateinit var citasProgramadas: Array<Int>

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Numero de Colegiado: $numColegiado")
        println("Especialidad: $especialidad")
    }

    fun getNumColegiado (): Int{
        return numColegiado
    }
    fun setNumColegiado (numColegiado: Int){
        this.numColegiado = numColegiado
    }

    fun getEspecialidad (): String{
        return especialidad
    }

    fun setEspecialidad (especialidad: String){
        this.especialidad = especialidad
    }
}