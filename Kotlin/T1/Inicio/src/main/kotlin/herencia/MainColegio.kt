package herencia

fun main()  {

    var alumno1: Alumno = Alumno("a","a","a",20,"1234")
    var alumno2: Alumno = Alumno("s","s","s",17,"1234")


    var profesor1: Profesor = Profesor("b","b","b",20,1000)
    var profesor2: Profesor = Profesor("d","d","d",20,3000)


    var listado = ArrayList<Persona>()
    listado.add(alumno1)
    listado.add(alumno2)
    listado.add(profesor1)
    listado.add(profesor2)

    println("Mostrando datos")
    listado.forEach ({it.mostrarDatos()})  }
}