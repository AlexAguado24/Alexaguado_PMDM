package model

class Participante ( id: Int , nombre: String, private var puntos: Int, private var presupuesto: Int )
    : Persona (id, nombre){

    var plantilla: ArrayList<Jugador>

    init {
        plantilla = ArrayList()
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Puntos: $ $puntos")
        println("Presupuesto: $ $presupuesto")
        if (plantilla.isNotEmpty()) {
            println("Plantilla: ")
            plantilla.forEach { jugador ->
                jugador.mostrarDatos()
            }
        }
    }

    fun ficharJugador(jugador: Jugador){
        var portero: Int = 0
        var defensa: Int = 0
        var mediocentro: Int = 0
        var delantero: Int = 0
        plantilla.forEach { item ->
            if (item.getPosicion() == "Portero") {
                portero += 1
            }
            if (item.getPosicion() == "Defensa") {
                defensa += 1
            }
            if (item.getPosicion() == "Mediocentro") {
                mediocentro += 1
            }
            if (item.getPosicion() == "Delantero") {
                delantero += 1
            }
        }
        if (portero <= 1  && defensa <= 2 && mediocentro <= 2 && delantero <= 1) {
            if (presupuesto == 0 && presupuesto <= jugador.getValor() ) {
                println("No cuentas con el presupuesto suficiente para fichar a este jugador")
            } else {
                plantilla.add(jugador)
                this.presupuesto -= jugador.getValor()
            }
        } else {
            println("No puedes tener mas jugadores en esa posicion")
        }
    }

    fun getPuntos(): Int{
        return puntos
    }

    fun setPuntos(puntos: Int){
        this.puntos = puntos
    }

    fun getPresupuesto(): Int{
        return presupuesto
    }
    fun setPresupuesto(presupuesto: Int){
        this.presupuesto = presupuesto
    }
}