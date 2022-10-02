package model

class LlamadaProvincial (nOrigen: Int, nDestino: Int, duracion: Int) :
    Llamada(nOrigen, nDestino, duracion) {

    init {
        calcularCoste()
    }

    override fun calcularCoste() {
        this.coste = this.duracion*0.15
    }
}