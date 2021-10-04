import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class Mapa {

    var mapa=Array(5){Array<Any>(5){"nada"}}
    var capitolio=Capitolio()
    fun itemsMapa(eleccion:Int){
        var capitolio=Capitolio()
        var items=capitolio.recargaItems()
        var c=0
        while (c!=eleccion) {
            var eleccionItem= Random.nextInt(0,100)
            var eleccionPosicionX=Random.nextInt(0,5)
            var eleccionPosicionY=Random.nextInt(0,5)
            if (mapa[eleccionPosicionX][eleccionPosicionY] == "nada") {
               mapa[eleccionPosicionX][eleccionPosicionY] = items[eleccionItem]!!
                c++

            }

        }
    }

    fun ganador(): Int {
        var jugadores=0
        for(i in 0..mapa.size-1){
            for(j in 0..mapa[i].size-1){
                if(mapa[i][j].toString()=="Jugador"){
                    jugadores++
                     }
                }
            }
        return jugadores
    }

    fun mostrarCaidos(){

        for(i in 0..capitolio.muertos.size-1){
            var muertos=capitolio.muertos[i] as Jugador
            println("Jugador del distro "+muertos.distrito+" Con "+muertos.fuerza+" puntos de fuerza y "+muertos.vida+" puntos de salud")
        }
    }

    fun mostrarGanador(): Jugador {
        var ganador=0
        var distrito:Jugador=Jugador()
        for(i in 0..mapa.size-1){
            for(j in 0..mapa[i].size-1){
                if(mapa[i][j].toString()=="Jugador"){
                   distrito= mapa[i][j] as Jugador
                }
            }
        }
        return distrito
    }

    fun jugadoresMap(){
        var jugadores=Jugador().jugadores()
        var c=0
        while(c!=10) {
            var eleccionPosicionX = Random.nextInt(0, 5)
            var eleccionPosicionY = Random.nextInt(0, 5)
            if (mapa[eleccionPosicionX][eleccionPosicionY] == "nada") {
                mapa[eleccionPosicionX][eleccionPosicionY] = jugadores[c]!!
                c++
            }
        }
    }

    fun movimientoJugador(){
        var jugador=Jugador()
        var map=Mapa()
        for(i in 0..mapa.size-1){
            for(j in 0..mapa[i].size-1){
                if(mapa[i][j].toString()=="Jugador"){
                    var eleccionX=Random.nextInt(-1, 2)
                    var eleccionY=Random.nextInt(-1, 2)
                    var seguir=map.comprobarLimites(i,j,eleccionX,eleccionY)
                    if(seguir==true){
                        if(mapa[i+eleccionX][j+eleccionY].toString()=="arma"){
                            darFuerza(i,j,i+eleccionX,j+eleccionY)
                            mapa[i+eleccionX][j+eleccionY]=mapa[i][j]
                            mapa[i][j]="nada"
                        }else if(mapa[i+eleccionX][j+eleccionY].toString()=="medicina"){
                            darVida(i,j,i+eleccionX,j+eleccionY)
                            mapa[i+eleccionX][j+eleccionY]=mapa[i][j]
                            mapa[i][j]="nada"
                        }else if(mapa[i+eleccionX][j+eleccionY].toString()=="trampa"){
                            capitolio.muertos.add(mapa[i][j])
                            mapa[i+eleccionX][j+eleccionY]="nada"
                            mapa[i][j]="nada"
                        }else if(mapa[i+eleccionX][j+eleccionY].toString()=="Jugador"){
                           var muerte= batalla(i,j,i+eleccionX,j+eleccionY)
                            if(muerte==1){
                                capitolio.muertos.add(mapa[i+eleccionX][j+eleccionY])
                                mapa[i+eleccionX][j+eleccionY]=mapa[i][j]
                                mapa[i][j]="nada"
                            }else if(muerte==2){
                                capitolio.muertos.add(mapa[i][j])
                                mapa[i][j]=mapa[i+eleccionX][j+eleccionY]
                                mapa[i+eleccionX][j+eleccionY]="nada"
                            }
                        }else if(mapa[i+eleccionX][j+eleccionY].toString()=="nada"){
                            mapa[i+eleccionX][j+eleccionY]=mapa[i][j]
                            mapa[i][j]="nada"
                        }

                    }
                }

            }

        }
    }

    fun batalla(x:Int,y:Int,auxX:Int,auxY:Int): Int {
        var jugador1=mapa[x][y] as Jugador
        var jugador2=mapa[auxX][auxY] as Jugador
        var muerte=0
        if(jugador1.fuerza>jugador2.fuerza){
            muerte=1
        }else if(jugador1.fuerza<jugador2.fuerza){
            muerte=2
        }else if(jugador1.fuerza==jugador2.fuerza){
            if(jugador1.vida>jugador2.vida){
                muerte=1
            }else if(jugador1.vida<jugador2.vida){
                muerte=2
            }else if(jugador1.vida==jugador2.vida){
                var moneda=Random.nextInt(1, 3)
                if (moneda==1){
                    muerte=1
                }else if(moneda==2){
                    muerte=2
                }
            }
        }
        return muerte
    }

    fun darFuerza(x:Int,y:Int,auxX:Int,auxY:Int){
        var poder=mapa[auxX][auxY] as Arma
        var poderJugador=mapa[x][y] as Jugador
        poderJugador.fuerza=poderJugador.fuerza+poder.poder
    }

    fun darVida(x:Int,y:Int,auxX:Int,auxY:Int){
        var poder=mapa[auxX][auxY] as Medicina
        var poderJugador=mapa[x][y] as Jugador
        poderJugador.vida=poderJugador.vida+poder.poder
    }

    fun comprobarLimites(x:Int,y:Int,auxX:Int,auxY:Int): Boolean {
        var limites=false
        if(x+auxX!=-1 && x+auxX!=5 && y+auxY!=-1 && y+auxY!=5){
            limites=true
        }
        return limites
    }

    fun estadoMapa(){
        for(i in 0..mapa.size-1){
            for(j in 0..mapa[i].size-1){
                print("  |  "+mapa[i][j].toString()+"  |  ")
                print(" ")
            }
            println("")
        }
    }
}