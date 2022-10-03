package model

class CentroSalud () {

    lateinit var listaPacientes: ArrayList<Paciente>
    lateinit var listaMedicos: ArrayList<Medico>

    init {
        listaMedicos = ArrayList()
        listaMedicos.add(Medico("Nick", "Rivera", "001",1,"traumatología"))
        listaMedicos.add(Medico("Hannibal", "Lecter", "002", 2,"digestivo"))
        listaMedicos.add(Medico("Sam", "Owens", "003",3,"psiquiatría"))
        listaMedicos.add(Medico("Martin", "Brenner", "004",4,"general"))
        listaMedicos.add(Medico("Stephen", "Strange", "005",5,"cirugía"))

        listaPacientes = ArrayList()
    }

    fun registrarPaciente(nombre: String, apellido: String, dni: String, nss: Int){
        var existePaciente: Boolean = false
        listaPacientes.forEach { paciente ->
            if (paciente.getNss() == nss){
                println("El paciente que quieres registrar ya existe")
                existePaciente = true
            }
        }
        if (!existePaciente){
            listaPacientes.add(Paciente(nombre, apellido, dni, nss))
        }
    }

    fun pedirCita(nss: Int, especialidad: String, numColegiado: Int, dia: Int, mes: Int){
        var paciente: Paciente? = null
        listaPacientes.forEach { item ->
            if (item.getNss() == nss) {
                paciente = item
            }
        }
        var medico: Medico? = null
        listaMedicos.forEach { item ->
            if (item.getNumColegiado() == numColegiado) {
                medico = item
            }
        }
        if (medico != null && paciente != null) {
            if (medico!!.hayDisponibilidad(dia.toString(), mes.toString())){
                medico!!.agendarCita(dia, mes)
                paciente!!.agendarCita(dia, mes, medico!!,"prueba")
            } else {
                println("Fecha no disponible")
            }

        }
    }

    fun listarMedicosPorEspecialidad(especialidad: String){
        var existeMedico: Boolean = false
        listaMedicos.forEach { medico ->
            if (medico.getEspecialidad() == especialidad) {
                medico.mostrarDatos()
                existeMedico = true
            }
        }
        if (!existeMedico) {
            println("El medico que buscas no esta en el centro")
        }
    }

    fun listrDatosPaciente(nss: Int){
        var existe: Boolean = false
        listaPacientes.forEach { paciente ->
            if (paciente.getNss() == nss){
                existe = true
                paciente.mostrarDatos()
            }
        }
        if (!existe) {
            println("El paciente no esta en el sistema")
        }
    }




}