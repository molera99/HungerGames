fun main(){
var capitolio=Capitolio()
var items=capitolio.recargaItems()
    /*for(i in 0..items.size-1){
        println(items[i]?.descripcion)
    }*/
var mapa=Mapa()
    mapa.itemsMapa()
    mapa.jugadoresMap()
    mapa.estadoMapa()
println("cada 2 segundos")
    println("Un jugador se mueve")
mapa.movimientoJugador()
mapa.estadoMapa()


}