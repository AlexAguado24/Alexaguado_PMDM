package model

class LlamadaNacional(nOrigen: Int, nDestino: Int, duracion: Int, private var franja: Int) :
    Llamada(nOrigen, nDestino, duracion)  {

    init {
        calcularCoste()
    }

    override fun calcularCoste() {
        when (franja){
            1 -> {
                this.coste = this.duracion*0.20
            }
            2 -> {
                this.coste = this.duracion*0.25
            }
            3 -> {
                this.coste = this.duracion*0.30

            }
        }
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Franja $franja")
    }

}