package model

class Cita (var medico: Medico, var dia: Int, var mes: Int, var comentario: String){

    fun mostrarDatos(){
        println("Medico: ${medico.nombre}")
        println("Dia: $dia")
        println("Mes: $mes")
        println("Comentario: $comentario")
    }
}