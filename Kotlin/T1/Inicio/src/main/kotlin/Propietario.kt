class Propietario (var nombre:String, var apellido:String, val DNI: String){

    var telefono: Int? = null

    constructor(nombre: String, apellido: String, DNI: String, telefono: Int) : this(nombre,apellido,DNI){
        this.telefono = telefono
    }

}