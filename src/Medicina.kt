import kotlin.random.Random

class Medicina:Item {
var medicinas=0
    constructor(){
        this.poder=Random.nextInt(50,100)
        this.descripcion="Item que suma "+poder+" punto de vida"
        this.nombre="medicina"
    }
    override fun toString() = this.nombre
}