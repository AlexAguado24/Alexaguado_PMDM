package model

open abstract class Llamada (protected var nOrigen: Int, protected var nDestino: Int,
                             protected var duracion: Int){

    protected var coste: Double = 0.0


    abstract fun calcularCoste()

    open fun mostrarDatos(){
        println("Numero Origen $nOrigen")
        println("Numero Destino $nDestino")
        println("Duracion $duracion")
        println("Coste $coste")
    }

    fun getDURACION(): Int{
        return duracion
    }
    fun setDURACION(duracion: Int) {
        this.duracion = duracion
    }
    fun getCOSTE(): Double{
        return coste;
    }

    fun setCOSTE(coste: Double) {
        this.coste = coste
    }

}