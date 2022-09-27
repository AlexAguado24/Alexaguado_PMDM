import java.util.ArrayList

class Empresa {
    var listaTrabajadores: ArrayList<Trabajador>? = ArrayList()

    constructor(){
        listaTrabajadores
    }

    fun añadirTrabajador(trabajador: Trabajador){
        listaTrabajadores!!.add(trabajador)
    }

    fun listarTrabajadores(tipo: String){
        listaTrabajadores!!.forEachIndexed({index, tipo -> tipo.mostrarDator()})
    }

}