package model

class Jugador ( id: Int , nombre: String, private var posicion: String, private var valor: Int)
    : Persona (id, nombre) {

    private var puntuacion: Int = 0


    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Posicion: $posicion")
        println("Valor: $valor")
    }

    fun getPosicion(): String{
        return posicion
    }

    fun setPosicion(posicion: String){
        this.posicion = posicion
    }

    fun getValor(): Int{
        return valor
    }

    fun setClave(valor: Int){
        this.valor = valor
    }

    fun getPuntuacion(): Int{
        return puntuacion
    }

    fun setPuntuacion(puntuacion: Int){
        this.puntuacion = puntuacion
    }
}