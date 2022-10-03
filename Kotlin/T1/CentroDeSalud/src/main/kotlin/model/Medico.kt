package model

class Medico(nombre: String, apellido: String, dni: String, private var numColegiado: Int, private var especialidad: String)
    : Persona(nombre, apellido, dni) {

    lateinit var citas: ArrayList<String>

    init {
        citas = ArrayList()
    }


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Numero de Colegiado: $numColegiado")
        println("Especialidad: $especialidad")
        if (!citas.isEmpty()) {
            println("Citas: ")
            citas.forEach { item ->
                println("Cita el dia $item")
            }
        }
    }

    fun hayDisponibilidad(dia: String, mes: String):Boolean{
        var disponibilidad: Boolean = true
        citas.forEach { item->
            var diaM: String = item.split("-")[0]
            var mesM: String = item.split("-")[1]
            if (diaM.equals(dia) && mesM.equals(mes)) {
                disponibilidad = false
            }
        }
        return true
    }

    fun agendarCita(dia: Int, mes: Int){
        citas.add(dia,mes.toString())
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