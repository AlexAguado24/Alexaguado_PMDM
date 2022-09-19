// VARIABLES - FUNCIONES - CLASE

// FUNCIONES fun nombre(arg: Tipo ){
//}

// FUNCIONES fun nombre(arg: Tipo): Tipo_retorno{
//return
//}

fun main(arg: Array<String>){


    //tipo ( var(normal) o val(constante) ) nombre: Tipo = valor
    //lateinit

    /*var nombre: String? = null
    var edad: Int = 18
    val DNI = "123456789A"

    nombre = "borja"
    println(nombre?.length?:4)

    nombre = readLine()


    println("la longitud del nombre es ${nombre?.length}")
    println("Primera ejecucion de Kotlin")
    println("Hola soy "+nombre+" y tengo "+edad+" años")
    println("hola soy ${nombre} y tengo ${edad}")
    println("la suma de los numeros 2 y 4 es ${2+4}")*/

    //ejercicioAleatorio()
    //estructuraFor()
    //estructuraWhen()
    //funcionArray()
    //funcionListas()
}

/*fun estructuraIf() {

    /*println("Estructura de control if")
    //if (c) {} else {}
    //if  (c) {} else if (c) else {}
    //

    var nombre: String? = null
    println("Introduce tu nombre")
    nombre = readLine()

    if (nombre?.length?: 7 > 5){
        println("Nombre demasiado largo")
    } else {
        println("Nombre correcto")
    }*/

}*/

/*fun estructuraFor() {
    /*for (i in 1..50 step 5){
        //println(i)
        var aleatorio = (1..50).random()
    }*/
    /*for (i in 10 downTo 0){
        println(i)
    }*/

    /*var max = -1
    var min = 101
    var suma = 0
    var media = 0
    for (i in 1..10){
        var aleatorio = (1..100).random()
        suma += aleatorio

        if (max < aleatorio){
            max = aleatorio
        }
        if (min > aleatorio){
            min = aleatorio
        }


    }
    println("max = ${max}")
    println("min = ${min}")
    println("media = ${suma/10}")
    println("suma = ${suma}")*/
}*/
fun estructuraForeach(){
    //coleccion.foreach(parametro (it) -> ejecucion)
    (1..10).forEach({item -> println("ejecucion del foreach")
            println(item)})
}
fun ejercicioAleatorio (){
    var edad = 0
    println("introduce la edad")
    //edad = readLine() as Int
    edad = readLine()!!.toInt()
    if (edad >= 18) {
        var sumatorio = 0
        var max = -1
        var min = 101
        for (i in 1..10){
            var aleatorio = (1..100).random()
            sumatorio += aleatorio
            if (max < aleatorio){
                max = aleatorio
            }
            if (min > aleatorio){
                min = aleatorio
            }
        }
        println("La suma es ${sumatorio}")
        println("Max es ${max}")
        println("Min es ${min}")
        println("La media es ${sumatorio/10}")
    } else {
        println("edad minima no alcanzada")
    }
}

fun estructuraWhen (){
    //when dato{
    // valor -> {ejecuta}
    // valor -> {ejecuta}
    // valor -> {ejecuta}
    // default -> {ejecuta}
    // }
    println("introduce nota")
    var nota = readLine()!!.toInt()
    when (nota){
        1->{
            println("examen nulo")
        }
        5->{
            println("examen justo")
        }
        10->{
            println("examen perfecto")
        }
    }
}

fun calculoDeNota(nota: Int): Int {
    return nota*2
}

fun funcionArray() {
    var arrayPalabras: Array<String?> = arrayOfNulls<String>(5)
    arrayPalabras[0] = "Hola"
    arrayPalabras[1] = "que"
    arrayPalabras[2] = "tal"
    arrayPalabras[3] = "estas"
    arrayPalabras[4] = "tu"

    //arrayPalabras.forEach { item -> println(item) }
    //arrayPalabras.forEach { println(it) }
    //arrayPalabras.forEachIndexed({index, value -> println("${index} ${value}")})
    /*for (i in arrayPalabras){
        print(i+" ")
    }
    println()
    for (i in 0..arrayPalabras.size-1){
        println(arrayPalabras.get(i))
    }*/

    arrayPalabras.forEachIndexed({index, value ->
        if (index%2 == 0) {
            println(value)
        }
    })

    arrayPalabras.forEach {item ->
        if (item?.length!! >= 5){
            println(item)
        }
    }

}

fun funcionListas(){
    var listaAlumnos = ArrayList<String>()

    listaAlumnos.add("Marcos_")
    listaAlumnos.add("Ivan")
    listaAlumnos.add("Jessy_")
    listaAlumnos.add("Jorge")
    listaAlumnos.add("Sergio_")

    //listaAlumnos.set(0,"alumno nuevo")
    //listaAlumnos.removeIf ({ elemento-> elemento.contains("_") })
    //println(listaAlumnos.get(0))
    //listaAlumnos.set(0,"Alumno nuevo")
    //listaAlumnos.forEach ({ println(it) })
    listaAlumnos.find { it.contains("_1") }
}
