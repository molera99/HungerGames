import java.util.*
import kotlin.random.Random

class Capitolio {
    var muertos= arrayOfNulls<Any>(10)
    var items= arrayOfNulls<Item>(100)
    fun recargaItems(): Array<Item?> {
        for(i in 0..items.size-1) {
            var eleccion = Random.nextInt(1, 4)
            if (eleccion == 1) {
                var arma=Arma()
                items[i]=arma
            }else if (eleccion == 2) {
                var medicina=Medicina()
                items[i]=medicina
            }else if (eleccion == 3) {
                var trampa=Trampa()
                items[i]=trampa
            }
        }
        return items
    }

}