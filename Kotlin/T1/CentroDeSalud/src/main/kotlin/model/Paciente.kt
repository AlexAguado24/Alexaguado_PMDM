package model

class Paciente (nombre: String, apellido: String, dni: String, private var nss: Int)
    : Persona (nombre, apellido, dni){

    lateinit var citas: ArrayList<Cita>

    init {
        citas = ArrayList()
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("NSS: $nss")
        if (!citas.isEmpty()) {
            println("Citas: ")
            citas.forEach { item ->
                println("Cita el dia ${item.mostrarDatos()}")
            }
        }
    }

    fun agendarCita(dia: Int, mes: Int, m: Medico, c: String){
        citas.add(Cita(m,dia,mes,c))
    }

    fun getNss(): Int{
        return nss
    }
    fun setNss(nss: Int){
        this.nss = nss
    }

}