import model.Centralita
import model.LlamadaLocal
import model.LlamadaNacional
import model.LlamadaProvincial

fun main() {

    var centralita: Centralita? = Centralita()

    var provincial: LlamadaProvincial = LlamadaProvincial(1123,412,30)
    var nacional1: LlamadaNacional = LlamadaNacional(456,457,20,1)
    var nacional2: LlamadaNacional = LlamadaNacional(567,568,20,2)
    var nacional3: LlamadaNacional = LlamadaNacional(678,789,20,3)
    var local: LlamadaLocal = LlamadaLocal(821,218,10)

    centralita!!.registrarLlamada(local)
    centralita!!.registrarLlamada(nacional1)
    centralita!!.registrarLlamada(nacional2)
    centralita!!.registrarLlamada(nacional3)
    centralita!!.registrarLlamada(provincial)


    centralita!!.mostrarLlamadas("todas")

    centralita!!.calcularCostes()

}