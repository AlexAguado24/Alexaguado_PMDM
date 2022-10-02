package model

class LlamadaLocal(nOrigen: Int, nDestino: Int, duracion: Int) :
    Llamada(nOrigen, nDestino, duracion) {

    override fun calcularCoste() {
        this.coste = 0.0
    }
}