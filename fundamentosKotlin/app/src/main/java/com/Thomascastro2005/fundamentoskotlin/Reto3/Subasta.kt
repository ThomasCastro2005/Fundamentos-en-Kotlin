package com.Thomascastro2005.fundamentoskotlin.Reto3

class Subasta() {

    fun participantesOferta(articulo: Double) {

        var canOfertantes: Int = 5
        var ofertaGanadora = 0.0

        while (canOfertantes > 0) {
            print("¿DESEA OFERTAR A ESTE ARTICULO CON EL PRECIO DE $articulo? Si/No: ")
            var respuesta: String = readLine()!!.toString().lowercase()

            if (respuesta == "si") {
                print("Ingrese el precio a ofertar, debe ser mayor al precio base: ")
                var ofertaNueva: Double = readLine()!!.toDouble()
                if (ofertaNueva > articulo) {
                    ofertaGanadora = ofertaNueva
                } else {
                    println("La oferta debe ser mayor al precio base.")
                }
            } else {
                canOfertantes-- // Reducir el número de ofertantes si alguien decide no ofertar
            }
        }

        if (ofertaGanadora > 0) {
            println("La oferta ganadora es $ofertaGanadora")
        } else {
            println("La oferta se vendió a la casa de subastas con el precio de $articulo")
        }
    }
}










fun main() {
    println("BIENVENIDOS A LA GRAN SUBASTA!!!")
    println("1- Articulo 1")
    println("2- Articulo 2")
    println("3- Articulo 3")
    println("4- Articulo 4")
    print("Ingrese el numero del articulo que se va a subastar:")
    var opcion: Int = readLine()!!.toInt()

    val subasta = Subasta()
    when (opcion) {
        1 -> {
            val articulo1: Double = 3000.0
            println("El precio base del Articulo 1 es de ($articulo1)")
            subasta.participantesOferta(articulo1)
        }
        2 -> {
            val articulo2: Double = 2500.0
            println("El precio base del Articulo 2 es de ($articulo2)")
            subasta.participantesOferta(articulo2)
        }
        3 -> {
            val articulo3: Double = 3000.0
            println("El precio base del Articulo 3 es de ($articulo3)")
            subasta.participantesOferta(articulo3)
        }
        4 -> {
            val articulo4: Double = 7000.0
            println("El precio base del Articulo 4 es de ($articulo4)")
            subasta.participantesOferta(articulo4)
        }
        else -> {
            print("Este Articulo no esta o no existe para la Subasta, escoge otra opcion: ")
            opcion = readLine()!!.toInt()
        }
    }
}
