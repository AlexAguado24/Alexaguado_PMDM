package model

import kotlin.math.max

class Fantasy {

    lateinit var participantes: ArrayList<Participante>
    lateinit var jugadores: ArrayList<Jugador>
    var administrador: Administrador = Administrador(1, "Alex", 123)

    init {
        jugadores = ArrayList()
        jugadores.add(Jugador(1, "Marc-André ter Stegen", "Portero", 3000000))
        jugadores.add(Jugador(2, "Ronald Araújo", "Defensa", 4000000))
        jugadores.add(Jugador(3, "Eric García", "Defensa", 1000000))
        jugadores.add(Jugador(4, "Pedri", "Mediocentro", 5000000))
        jugadores.add(Jugador(5, "Robert Lewandowski", "Delantero", 8000000))
        jugadores.add(Jugador(6, "Courtois", "Portero", 3000000))
        jugadores.add(Jugador(7, "David Alaba", "Defensa", 4000000))
        jugadores.add(Jugador(8, "Jesús Vallejo", "Defensa", 500000))
        jugadores.add(Jugador(9, "Luka Modric", "Mediocentro", 5000000))
        jugadores.add(Jugador(10, "Karim Benzema", "Delantero", 8000000))
        jugadores.add(Jugador(11, "Ledesma", "Portero", 500000))
        jugadores.add(Jugador(12, "Juan Cala", "Defensa", 300000))
        jugadores.add(Jugador(13, "Zaldua", "Defensa", 400000))
        jugadores.add(Jugador(14, "Alez Fernández", "Mediocentro", 700000))
        jugadores.add(Jugador(15, "Choco Lozano", "Delantero", 800000))
        jugadores.add(Jugador(16, "Rajković", "Portero", 300000))
        jugadores.add(Jugador(17, "Raíllo", "Defensa", 200000))
        jugadores.add(Jugador(18, "Maffeo", "Defensa", 300000))
        jugadores.add(Jugador(19, "Ruiz de Galarreta", "Mediocentro", 400000))
        jugadores.add(Jugador(20, "Remiro", "Portero", 1000000))
        jugadores.add(Jugador(21, "Elustondo", "Defensa", 900000))
        jugadores.add(Jugador(22, "Zubeldia", "Defensa", 800000))
        jugadores.add(Jugador(23, "Zubimendi", "Mediocentro", 1000000))
        jugadores.add(Jugador(24, "Take Kubo", "Delantero", 800000))
        jugadores.add(Jugador(25, "Ángel", "Delantero", 300000))
        participantes = ArrayList()
    }

    fun listarJugadores() {
        jugadores.forEach { item ->
            if (item.getValor() >= 3000000) {
                item.mostrarDatos()
            }
        }
    }

    fun darPuntos() {
        jugadores.get(0).setPuntuacion(10)
        jugadores.get(1).setPuntuacion(0)
        jugadores.get(2).setPuntuacion(3)
        jugadores.get(3).setPuntuacion(23)
        jugadores.get(4).setPuntuacion(15)
        jugadores.get(5).setPuntuacion(1)
        jugadores.get(6).setPuntuacion(5)
        jugadores.get(7).setPuntuacion(10)
        jugadores.get(8).setPuntuacion(5)
        jugadores.get(9).setPuntuacion(10)
        jugadores.get(10).setPuntuacion(6)
        jugadores.get(11).setPuntuacion(3)
        jugadores.get(12).setPuntuacion(6)
        jugadores.get(13).setPuntuacion(9)
        jugadores.get(14).setPuntuacion(4)
        jugadores.get(15).setPuntuacion(3)
        jugadores.get(16).setPuntuacion(6)
        jugadores.get(17).setPuntuacion(0)
        jugadores.get(18).setPuntuacion(7)
        jugadores.get(18).setPuntuacion(4)
        jugadores.get(20).setPuntuacion(3)
        jugadores.get(21).setPuntuacion(5)
        jugadores.get(22).setPuntuacion(6)
        jugadores.get(23).setPuntuacion(7)
        jugadores.get(24).setPuntuacion(4)
    }

    /*fun mostrarGanador (){
        participantes.forEachIndexed { index, item ->
            if (index.) {

            }
        }
    }*/


    fun empezarJuego(clave: Int) {
        if (administrador.getClave() == clave) {
            println("Empieza el juego")
            darPuntos()
            participantes.forEach { item ->
                item.plantilla.forEach { jugador ->
                    item.setPuntos(+jugador.getPuntuacion())
                }
            }

        } else {
            println("La clave no coincide con la del administrador")
        }
    }
}
