package model

fun main() {

    var fantasy: Fantasy = Fantasy()
    var marcos: Participante = Participante(1,"Marcos",0,10000000)
    var jorge: Participante = Participante(2,"Jorge",0,10000000)
    var jessy: Participante = Participante(3,"Jessy",0,10000000)
    var patri: Participante = Participante(4,"Patri",0,10000000)


    //fantasy.listarJugadores()

    marcos.ficharJugador(fantasy.jugadores.get(0))
    marcos.ficharJugador(fantasy.jugadores.get(16))
    marcos.ficharJugador(fantasy.jugadores.get(17))
    marcos.ficharJugador(fantasy.jugadores.get(22))
    marcos.ficharJugador(fantasy.jugadores.get(13))
    marcos.ficharJugador(fantasy.jugadores.get(14))

    jorge.ficharJugador(fantasy.jugadores.get(10))
    jorge.ficharJugador(fantasy.jugadores.get(1))
    jorge.ficharJugador(fantasy.jugadores.get(2))
    jorge.ficharJugador(fantasy.jugadores.get(13))
    jorge.ficharJugador(fantasy.jugadores.get(22))
    jorge.ficharJugador(fantasy.jugadores.get(23))

    jessy.ficharJugador(fantasy.jugadores.get(10))
    jessy.ficharJugador(fantasy.jugadores.get(16))
    jessy.ficharJugador(fantasy.jugadores.get(17))
    jessy.ficharJugador(fantasy.jugadores.get(22))
    jessy.ficharJugador(fantasy.jugadores.get(13))
    jessy.ficharJugador(fantasy.jugadores.get(23))

    patri.ficharJugador(fantasy.jugadores.get(10))
    patri.ficharJugador(fantasy.jugadores.get(16))
    patri.ficharJugador(fantasy.jugadores.get(17))
    patri.ficharJugador(fantasy.jugadores.get(22))
    patri.ficharJugador(fantasy.jugadores.get(13))

    fantasy.empezarJuego(123)

    marcos.mostrarDatos()
    jessy.mostrarDatos()
    jorge.mostrarDatos()
    patri.mostrarDatos()

}