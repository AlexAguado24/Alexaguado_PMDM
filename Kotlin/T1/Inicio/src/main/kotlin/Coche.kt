class Coche {

    var marca: String
    var modelo: String
        get() = field
        set(value) {
            field = value
        }
    var cv: Int
        get() = field
        set(cv) {
            field = cv
        }
    var bastidor: String? = null
    var velocidad: Int? = null


    constructor(marca: String, modelo:String, cv:Int){
        this.marca = marca
        this.modelo = modelo
        this.cv = cv
    }
    constructor(marca: String, modelo:String, cv:Int, bastidor: String){
        this.marca = marca
        this.modelo = modelo
        this.cv = cv
        this.bastidor = bastidor
    }

    //metodos
    fun acelerar(velocidad: Int){
        this.velocidad = this.velocidad?.plus(velocidad)
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