// VARIABLES - FUNCIONES - CLASE

// FUNCIONES fun nombre(arg: Tipo ){
//}

// FUNCIONES fun nombre(arg: Tipo): Tipo_retorno{
//return
//}

fun main(arg: Array<String>){


    //tipo ( var(normal) o val(constante) ) nombre: Tipo = valor
    //lateinit

    var nombre: String? = null
    var edad = 18
    val DNI = "123456789A"
    println(nombre)

    nombre = readLine()


    println("la longitud del nombre es ${nombre?.length}")
    println("Primera ejecucion de Kotlin")
    //println("Hola soy "+nombre+" y tengo "+edad+" años")
    println("hola soy ${nombre} y tengo ${edad}")
    println("la suma de los numeros 2 y 4 es ${2+4}")

}
