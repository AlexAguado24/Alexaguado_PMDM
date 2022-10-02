import model.Centralita
import model.LlamadaLocal
import model.LlamadaNacional
import model.LlamadaProvincial

fun main() {

    var centralita: Centralita? = Centralita()

    var provincial1: LlamadaProvincial = LlamadaProvincial(1123,412,30)
    var provincial2: LlamadaProvincial = LlamadaProvincial(2345,124,15)
    var provincial3: LlamadaProvincial = LlamadaProvincial(3456,365,21)

    var nacional1: LlamadaNacional = LlamadaNacional(456,457,20,1)
    var nacional2: LlamadaNacional = LlamadaNacional(567,568,20,2)
    var nacional3: LlamadaNacional = LlamadaNacional(678,789,20,3)

    var local1: LlamadaLocal = LlamadaLocal(821,218,10)
    var local2: LlamadaLocal = LlamadaLocal(912,245,20)
    var local3: LlamadaLocal = LlamadaLocal(934,321,30)

    centralita!!.registrarLlamada(local1)
    centralita!!.registrarLlamada(local2)
    centralita!!.registrarLlamada(local3)
    centralita!!.registrarLlamada(nacional1)
    centralita!!.registrarLlamada(nacional2)
    centralita!!.registrarLlamada(nacional3)
    centralita!!.registrarLlamada(provincial1)
    centralita!!.registrarLlamada(provincial2)
    centralita!!.registrarLlamada(provincial3)


    centralita!!.mostrarLlamadas("todas")

    centralita!!.calcularCostes()

}