fun main() {

    var empresa: Empresa? = Empresa()


    do {
        println("1. Registrar trabajador")
        println("2. Listar trabajador")
        println("3. Mostrar datos trabajador")
        println("Introduce la opcion deseada")
        var opcion = readln().toInt()

        when(opcion){
            1->{
                println("Registrando Trabajador")
                println("¿Que puesto tiene el trabajador?")
                println("1. Jefe")
                println("2. Asalariado")
                println("3 Autonomo")

                var puesto = readln().toInt()

                if (puesto == 1) {
                    println("Indica su nombre")
                    var nombre  = readln()
                    println("Indica su apellido")
                    var apellido  = readln()
                    println("Indica su dni")
                    var dni  = readln()
                    println("Indica su acciones")
                    var acciones  = readln().toInt()
                    println("Indica su befeficios")
                    var beneficios  = readln().toInt()
                    var jefe: Jefe = Jefe(nombre,apellido, dni, acciones, beneficios)
                    empresa?.añadirTrabajador(jefe)
                } else if (puesto == 2) {
                    println("Indica su nombre")
                    var nombre  = readln()
                    println("Indica su apellido")
                    var apellido  = readln()
                    println("Indica su dni")
                    var dni  = readln()
                    println("Indica su sueldo")
                    var sueldo  = readln().toInt()
                    println("Indica su numero de pagas")
                    var numPagas  = readln().toInt()
                    var asalariado: Asalariado = Asalariado(nombre, apellido, dni,sueldo,numPagas)
                    empresa?.añadirTrabajador(asalariado)
                } else {
                    println("Indica su nombre")
                    var nombre  = readln()
                    println("Indica su apellido")
                    var apellido  = readln()
                    println("Indica su dni")
                    var dni  = readln()
                    println("Indica su sueldo")
                    var sueldo  = readln().toInt()
                    var autonomo: Autonomo = Autonomo(nombre, apellido, dni,sueldo)
                    empresa?.añadirTrabajador(autonomo)
                }
            }
            2->{
                println("Listando Trabajadores")
                println("¿Que Trabajadores quieres listar?")
                println("1. Asalariados")
                println("2. Autonomos")
                println("3. Todos")
                var listar = readln().toInt()
                if (listar == 1){
                    empresa!!.listaTrabajadores?.forEach { index ->
                        if (index is Asalariado){
                            index.mostrarDator()
                        }
                    }
                }
                if (listar == 2){
                    empresa!!.listaTrabajadores?.forEach { index ->
                        if (index is Autonomo){
                            index.mostrarDator()
                        }
                    }
                }
                if (listar == 3){
                    empresa!!.listarTrabajadores("Asalariados")
                }
            }
        }
    } while (opcion != 0)

}