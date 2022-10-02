package model

class Centralita (){

    var listaLlamadas: ArrayList<Llamada>?
    var costeTotal: Double = 0.0

    init {
        listaLlamadas = ArrayList()
    }

    fun calcularCostes(){
        listaLlamadas!!.forEach { item ->
            this.costeTotal += item.getCOSTE()
        }
        println("El coste de las llamadas es $costeTotal")
    }

    fun registrarLlamada(llamada: Llamada){
        listaLlamadas!!.add(llamada)
        println("Llamada agregada")
        llamada.mostrarDatos()
        this.costeTotal += llamada.getCOSTE()
    }

    fun mostrarLlamadas (tipo: String){
        when (tipo){
            "locales" ->{
                listarLocales()
            }
            "provinciales" ->{
                listarProvinciales()
            }
            "nacionales" ->{
                listarNacionales()
            }
            "todas" ->{
                listarTodas()
            }
        }
    }

    fun listarTodas(){
        listaLlamadas!!.forEach { llamada ->
            println("Llamadas")
            llamada.mostrarDatos()
        }
    }

    fun listarLocales(){
        listaLlamadas!!.forEach { llamada ->
            if (llamada is LlamadaLocal) {
                println("Locales")
                llamada.mostrarDatos()
            }
        }
    }

    fun listarProvinciales(){
        listaLlamadas!!.forEach { llamada ->
            if (llamada is LlamadaProvincial) {
                println("Provinciales")
                llamada.mostrarDatos()
            }
        }
    }

    fun listarNacionales(){
        listaLlamadas!!.forEach { llamada ->
            if (llamada is LlamadaNacional) {
                println("Nacionales")
                llamada.mostrarDatos()
            }
        }
    }
}