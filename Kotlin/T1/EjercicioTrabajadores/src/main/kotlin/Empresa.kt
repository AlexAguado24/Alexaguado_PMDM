import java.util.ArrayList

class Empresa {
    var listaTrabajadores: ArrayList<Trabajador>? = null

    constructor(){
        listaTrabajadores
    }

    fun añadirTrabajador(trabajador: Trabajador){
        listaTrabajadores!!.add(trabajador)
    }



}