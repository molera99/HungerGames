fun main(){
var capitolio=Capitolio()
var items=capitolio.recargaItems()

var mapa=Mapa()
    mapa.itemsMapa(10)
    mapa.jugadoresMap()
    mapa.estadoMapa()
println("cada 2 segundos")
    println("se mueven jugadores")
mapa.movimientoJugador()
    println("cada 5 segundos")
    println("se suman 4 items y se muestra el estado del mapa")
    mapa.itemsMapa(4)
    mapa.estadoMapa()

}