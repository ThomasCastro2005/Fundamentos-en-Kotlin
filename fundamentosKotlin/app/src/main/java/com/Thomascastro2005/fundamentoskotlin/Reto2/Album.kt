package com.Thomascastro2005.fundamentoskotlin.Reto2

class Album {
    var albumCanciones = mutableListOf<Array<Any>>()

    fun infoCanciones() {
        albumCanciones.add(arrayOf("Matalas", "Thomas Castro", 2005, 3000))
        albumCanciones.add(arrayOf("Noche sin ti", "María Pérez", 2012, 4000))
        albumCanciones.add(arrayOf("En la playa", "Carlos Rodríguez", 1998, 1000))
        albumCanciones.add(arrayOf("Vuela alto", "Ana Gómez", 2020, 2500))
    }

    fun mostrarReproducciones() {
        var reproduccionesMaximas = 0
        var cancionPopular = ""

        for (i in albumCanciones) {
            var canReproduc: Int = i[3] as Int
            if (canReproduc > 1000) {
                println("La canción ${i[0]} tiene una cantidad de reproducciones de: $canReproduc por lo que esta canción es POPULAR.")
            } else {
                println("La canción ${i[0]} tiene una cantidad de reproducciones de: $canReproduc por lo que esta canción es POCO POPULAR.")
            }

            if (canReproduc > reproduccionesMaximas) {
                reproduccionesMaximas = canReproduc
                cancionPopular = i[0] as String
            }
        }

        println("\nLa canción más popular es $cancionPopular con un total de reproducciones de ($reproduccionesMaximas)")
    }
}

fun main() {
    val album = Album()
    album.infoCanciones()

    print("Ingrese la cantidad De canciones del Album: ")
    val canCanciones: Int = readLine()!!.toInt()

    if (canCanciones > album.albumCanciones.size) {
        album.mostrarReproducciones()
    } else {
        print("El album no tiene esta cantidad de canciones")
    }
}
