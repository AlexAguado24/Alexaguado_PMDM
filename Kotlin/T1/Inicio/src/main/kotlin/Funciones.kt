class Funciones {

    fun main(){
        //funcionParametros("Borja", 10)
        //funcionParametros(arg1 = "Borja", arg2 = 10)
        //funcionPorDefecto( numDos = 5)
        funcionLambdaSuma(1,4)
    }

    fun funcionSimple(){
        println("Funcion simple ejecutada")
    }

    fun funcionParametros(arg1: String, arg2 : Int){
        println("$arg1")
        println("$arg2")
    }

    fun funcionPorDefecto(numUno: Int=200, numDos: Int, numTres: Int=100){
        println("${numUno+numDos+numTres}")
    }

    fun funcionSuma(num1: Int, num2: Int) = println("${num1+num2}")

    fun funcionRetorno() : String{
        return "Borja"
    }

    var funcionLambdaSuma: (a:Int, b:Int) -> Unit =  { arg1: Int, arg2: Int ->
        if (arg1 > 0 && arg2 > 0) {
            println("${arg1 + arg2}")
        } else {
            println("Alguno de los numeros es negativo")
        }
    }


}