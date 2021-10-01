import kotlin.random.Random

class Arma: Item {

    constructor(){
        this.poder=Random.nextInt(50,100)
        this.descripcion="Item que suma "+poder+" punto de fuerza"
        this.nombre="arma"
    }
}