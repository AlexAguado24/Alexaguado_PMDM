class Coche (var marca: String, var modelo: String){


    var cv: Int? = 0
        get() = field
        set(cv) {
            field = cv
        }
    var bastidor: String? = null
    var velocidad: Int? = null
    lateinit var propietario: Propietario



    constructor(marca: String, modelo:String, cv:Int): this(marca, modelo){
        this.cv = cv
    }
    constructor(marca: String, modelo:String, cv:Int, bastidor: String): this(marca, modelo){
        this.cv = cv
        this.bastidor = bastidor
    }

    //metodos
    fun acelerar(velocidad: Int){
        this.velocidad = this.velocidad?.plus(velocidad)
    }

    fun asignarPropietario(propietario: Propietario){
        this.propietario = propietario
    }

    //
    var disminucionVelocidad: (Int)->Boolean = {v -> if ((this.velocidad!!-v) < 0) false
    else true
    }

    fun decelerar(velocidad:  Int){
        this.velocidad = this.velocidad?.plus(velocidad)
    }

    fun parar(){
        this.velocidad = 0
    }
    //getter setter

    fun getVelocidad(): Int{
        return this.velocidad?: 0
    }
    fun setVelocidad(velocidad: Int){
        this.velocidad = velocidad
    }
    //ToString
}