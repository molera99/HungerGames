fun main(){
var capitolio=Capitolio()
var items=capitolio.recargaItems()
var mapa=Mapa()
    var ganador=false
    var tiempo=0
        mapa.itemsMapa(10)
        mapa.jugadoresMap()
    println("Mapa Inicial")
    println("")
        mapa.estadoMapa()
        println("")
    while(ganador!=true) {
        if(tiempo%2==0) {
            Thread.sleep(2000)
            println("Los jugadores se desplazan")
            println("")
            mapa.movimientoJugador()
        }
        if(tiempo%5==0) {
            Thread.sleep(5000)
            println("Se han añadido 4 items, este es el estado actual del mapa")
            println("")
            mapa.itemsMapa(4)
            mapa.estadoMapa()
            println("")
        }
        var jugadoresVivos=mapa.ganador()
        if(jugadoresVivos==1){
            var campeon=mapa.mostrarGanador()
            println("ha ganado el jugador del distrito "+campeon.distrito+" con "+ campeon.fuerza+" puntos de fuerza y "+campeon.vida+" puntos de salud")
            println("")
            mapa.estadoMapa()
            println("")
            println("Estos son los caidos en batalla")
            println("")
            mapa.mostrarCaidos()
            println("")
            ganador=true
        }  else if(jugadoresVivos==0){
            println("No gana nadie, las trampas ganan")
            mapa.estadoMapa()
            println("")
            println("Estos son los caidos en batalla")
            println("")
            mapa.mostrarCaidos()
            println("")
            ganador=true
        } else{
            println("quedan "+jugadoresVivos+ " jugadores vivos")
            println("")
        }
        tiempo++
    }
}