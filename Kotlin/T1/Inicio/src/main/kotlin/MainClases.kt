fun main(){
    var coche1: Coche = Coche("Mercedes","C220",100)
    var coche2: Coche = Coche("Mercedes","C220",100,"0000000")
    var propietario = Propietario("","","")


    coche1.acelerar(100)

    coche1.disminucionVelocidad(50)
    coche1.setVelocidad(100)
    println(coche1.getVelocidad())
}