import model.CentroSalud

fun main() {

    var opcion: Int
    var centroSalud: CentroSalud = CentroSalud()

    println("Bienvenido al centro de salud")
    println("Indica la opcion que deseas")
    println("1. Registrar Paciente")
    println("2. Pedir Cita")
    println("3. Listar medicos disponibles")
    println("4. Listar citas de un paciente")
    opcion = readln().toInt()

    do {
        when (opcion) {
            1 -> {
                println("Registrando paciente")
                println("Indica su nombre")
                var nombre = readln()
                println("Indica su apellido")
                var apellido = readln()
                println("Indica su dni")
                var dni = readln()
                println("Indica su nss")
                var nss = readln().toInt()
                centroSalud.registrarPaciente(nombre, apellido, dni, nss)
            }
            2 -> {
                println("Indica su nss")
                var nss = readln().toInt()
                println("Indica dia de la cita")
                var dia = readln().toInt()
                println("Indica mes de la cita")
                var mes = readln().toInt()
                println("Indica numero de colegiado")
                var numColegiado = readln().toInt()
                println("Indica especialidad")
                var especialidad = readln()
            }
            3 ->{
                println("Listando medico")
                println("Indica su especialidad")
                var especialidad = readln()
                centroSalud.listarMedicosPorEspecialidad(especialidad)
            }
            4 ->{
                println("Listando datos del paciente")
                println("De que paciente se trata?")
                var nss = readln().toInt()
                centroSalud.listrDatosPaciente(nss)
            }
        }
    } while (opcion != 0)
}