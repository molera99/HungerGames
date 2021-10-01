import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class Mapa {

    var mapa=Array(5){Array<Any>(5){"nada"}}
    fun itemsMapa(){
        var capitolio=Capitolio()
        var items=capitolio.recargaItems()
        var c=0
        while (c!=10) {
            var eleccionItem= Random.nextInt(0,100)
            var eleccionPosicionX=Random.nextInt(0,5)
            var eleccionPosicionY=Random.nextInt(0,5)
            if (mapa[eleccionPosicionX][eleccionPosicionY] == "nada") {
               mapa[eleccionPosicionX][eleccionPosicionY] = items[eleccionItem]!!
                c++

            }

        }
        /*if(mapa[0][0]!=String && mapa[0][0]!=jugador){
            var p=mapa[0][0] as Item
            println(p.nombre)
        }*/


    }

    fun jugadoresMap(){
        var jugador=Jugador()
        var jugadores=Jugador().jugadores()
        var c=0
        while(c!=10) {
            var eleccionJugador = Random.nextInt(0, 10)
            var eleccionPosicionX = Random.nextInt(0, 5)
            var eleccionPosicionY = Random.nextInt(0, 5)
            if (mapa[eleccionPosicionX][eleccionPosicionY] == "nada") {
                mapa[eleccionPosicionX][eleccionPosicionY] = jugadores[eleccionJugador]!!
                c++
            }
        }
    }

    fun estadoMapa(){
        for(i in 0..mapa.size-1){
            for(j in 0..mapa[i].size-1){
                print(mapa[i][j])
                print(" ")
            }
            println("")
        }
    }
}