package com.Thomascastro2005.fundamentoskotlin.Reto1

import android.os.Build
import androidx.annotation.RequiresApi
import kotlin.random.Random
class Telefono {

}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    // Creación de un mapa para almacenar los mensajes por número de teléfono
    var mensajesTelefono = mutableMapOf<String, MutableList<String>>()
    // Creación de un mapa para almacenar el conteo de mensajes por número de teléfono
    var conteoMensajes = mutableMapOf<String, Int>()
    var notificaciones = Random.nextInt(1, 151)
    do {
        println("Ingrese su nombre")
        var nombre= readLine()!!.toString().lowercase()
        println("Bienvenido Sr(a) $nombre usted recibio un resumen programado de notificaciones\n¿Desea conocer su resumen programado de notificaciones?\n1. si\n2. No")
        var pregunta= readLine()!!.toString().lowercase()
        if (pregunta=="1" || pregunta=="si"){
            if (notificaciones in 1..100){
                println("Hoy usted recibio $notificaciones notificaciones")
            }else if (notificaciones>=100){
                println("Hoy usted recibio 99+ notificaciones")
            }else{
                println("Hoy usted no recibio notificaciones")
            }
        }else if(pregunta.equals("no")){
            println("Saliendo del programa.\nEsperamos que vuelva pronto")
            return
        }else{
            println("Respuesta no válida.")
            break
        }
        var continuar=true
        while (continuar){
            println("A continuacion le aparecera una lista de opciones. ¡Por favor elija una!")
            var mensaje="""
            1. Guardar mensaje
            2. Mostrar conteo de mensajes
            3. Mostrar todos los mensajes
            4. Salir
        """.trimIndent()
            println(mensaje)
            var respuesta= readLine()!!.toInt()
            when(respuesta) {
                1 -> {
                    do {
                        while (true) {
                            println("Ingrese su número de teléfono (o 'salir' para terminar):")
                            var numTel = readLine()!!.toString().lowercase()
                            if (numTel == "salir") {
                                break
                            }
                            println("Ingrese el mensaje que desea almacenar:")
                            var mensaje = readLine()!!.toString().lowercase()
                            // Verificar si el número de teléfono ya está en el mapa
                            if (mensajesTelefono.containsKey(numTel)) {
                                // Si el número de teléfono ya existe, agregar el mensaje a la lista correspondiente
                                mensajesTelefono[numTel]?.add(mensaje)
                            } else {
                                // Si es un nuevo número de teléfono, crear una nueva lista y agregar el mensaje
                                mensajesTelefono[numTel] = mutableListOf(mensaje)
                            }
                            // Actualizar el conteo de mensajes para el número de teléfono
                            conteoMensajes[numTel] = conteoMensajes.getOrDefault(numTel, 0) + 1
                        }
                        while (true) {
                            println("Ingrese el número de teléfono para mostrar sus mensajes (o 'salir' para terminar):")
                            var numTelBusqueda = readLine()!!.toString().lowercase()
                            if (numTelBusqueda == "salir") {
                                break
                            }
                            // Obtener la lista de mensajes asociada al número de teléfono ingresado
                            var mensajes = mensajesTelefono[numTelBusqueda]
                            // Verificar si hay mensajes asociados al número de teléfono
                            if (mensajes == null) {
                                println("Número de teléfono no encontrado.")
                            } else {
                                // Si hay mensajes, obtener el conteo de mensajes para el número de teléfono
                                var conteo = conteoMensajes.getOrDefault(numTelBusqueda, 0)
                                println("Mensajes para el número $numTelBusqueda (Total: $conteo):")
                                mensajes.forEachIndexed { index, mensaje ->
                                    println("${index + 1}. $mensaje")
                                }
                            }
                        }
                        println("¿Desea ingresar otro numero de telefono?")
                        var respuesta= readLine()!!.toString().lowercase()
                    }while (respuesta.equals("si"))
                }
                2 -> {
                    for ((clave, valor) in conteoMensajes.entries){
                        println("Telefono: $clave\nMensajes: $valor mensajes")
                        println("----------------------------------")
                    }
                }
                3 -> {
                    for ((clave, valor) in mensajesTelefono.entries){
                        println("Telefono: $clave\nConteo de mensajes: $valor")
                        println("----------------------------------")
                    }
                }
                4 -> {
                    println("Programa finalizado")
                    return
                }
            }
        }
        if (continuar){
            println("Presione enter para continuar")
            readLine()
        }
        println("¿Desea volver a añadir mas mensajes?")
        var decision= readLine()!!.toString().lowercase()
    }while (decision.equals("si"))
}