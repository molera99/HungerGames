class Jugador {
    var distrito:Int = 0
    var vida:Int = 0
    var fuerza:Int = 0

    constructor(){

    }
    constructor(distrito:Int){
        this.distrito=distrito
    }

    fun jugadores(): Array<Jugador?>{
        var jugadores= arrayOfNulls<Jugador>(10)
        var c=0
        for(i in 0..4){
                var jugador=Jugador(i)
                jugadores[c]=jugador

                var jugador2=Jugador(i)
                jugadores[c+1]=jugador2
            if(c!=8){
                c=c+2
            }



            }

        return jugadores

    }

}