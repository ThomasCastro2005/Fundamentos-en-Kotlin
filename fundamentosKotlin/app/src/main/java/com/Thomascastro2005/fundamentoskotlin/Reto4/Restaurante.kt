package com.Thomascastro2005.fundamentoskotlin.Reto4

class Restaurante {
    private val menu = mutableMapOf<Int, Plato>()

    class Plato(val codigo: Int, var nombre: String, var descripcion: String, var precio: Double) {
        override  fun toString(): String {
            return "Código: $codigo, Nombre: $nombre, Descripción: $descripcion, Precio: $precio"
        }
    }

    fun agregarPlato(codigo: Int, nombre: String, descripcion: String, precio: Double) {
        /*Aqui estamos instancia la clase Plato*/
        val plato = Plato(codigo, nombre, descripcion, precio)
        menu[codigo] = plato
    }

    fun mostrarPlatos() {
        println("------- Menú del Restaurante -------")
        for (plato in menu.values) {
            println(plato.toString())
        }
    }

    fun mostrarPlatoPorCodigo(codigo: Int) {
        val plato = menu[codigo]
        if (plato != null) {
            println("------- Plato con código $codigo -------")
            println(plato.toString())
        } else {
            println("No se encontró ningún plato con el código $codigo")
        }
    }

    fun modificarPlato(codigo: Int, nombre: String, descripcion: String, precio: Double) {
        val plato = menu[codigo]
        if (plato != null) {
            plato.nombre = nombre
            plato.descripcion = descripcion
            plato.precio = precio
            println("Plato con código $codigo modificado exitosamente.")
        } else {
            println("No se encontró ningún plato con el código $codigo")
        }
    }

    fun eliminarPlato(codigo: Int) {
        if (menu.remove(codigo) != null) {
            println("El Plato con el código $codigo se ha eliminado.")
        } else {
            println("No se encontró ningún plato con el código $codigo")
        }
    }
}

fun main() {
    val restaurante = Restaurante()
    var continuar = true


    while (continuar) {
        println("\nMenú del Restaurante")
        println("1. Agregar plato")
        println("2. Mostrar todos los platos")
        println("3. Mostrar plato por código")
        println("4. Modificar plato")
        println("5. Eliminar plato")
        println("6. Salir")
        println("")
        print("Ingrese la opción deseada: ")
        var op: Int = readLine()!!.toInt()
        when (op) {
            1 -> {
                println("Agregar Plato")
                print("Ingrese el código del plato: ")
                val codigo = readLine()!!.toInt()
                print("Ingrese el nombre del plato: ")
                val nombre = readLine()!!.toString()
                print("Ingrese la descripción del plato: ")
                val descripcion = readLine()!!.toString()
                print("Ingrese el precio del plato: ")
                val precio = readLine()!!.toDouble()

                restaurante.agregarPlato(codigo, nombre, descripcion, precio)
                println("El Plato  ha sido agregado exitosamente.")
            }
            2 ->{
                println("Todos los Platos")
                restaurante.mostrarPlatos()
            }
            3 ->{
                println("Mostrar Plato por Código")
                print("Ingrese el código del plato: ")
                val codigo = readLine()!!.toInt()
                if (codigo != null) {
                    restaurante.mostrarPlatoPorCodigo(codigo)
                }else{
                    println("Código inválido.")
                }
            }
            4 ->{
                println("Modificar Plato")
                print("Ingrese el código del plato que desea modificar: ")
                val codigo = readLine()!!.toInt()
                if (codigo != null) {
                    println("*SI DESEA DEJAR EL CAMPO COMO ESTABA DEJELO VACIO Y SIGA**")
                    println("")
                    print("Ingrese el nuevo nombre: ")
                    val nombre = readLine()!!.toString()
                    print("Ingrese la nueva descripción: ")
                    val descripcion = readLine()!!.toString()
                    print("Ingrese el nuevo precio: ")
                    val precio = readLine()!!.toDouble()

                    restaurante.modificarPlato(codigo, nombre, descripcion, precio)
                }else{
                    println("Código incorrecto.")
                }
            }
            5 ->{
                println("Eliminar Plato")
                print("Ingrese el código del plato que desea eliminar: ")
                val codigo = readLine()!!.toInt()
                if (codigo != null) {
                    restaurante.eliminarPlato(codigo)
                }else{
                    println("Código incorrecto.")
                }
            }
            6 ->{
                continuar = false
                println("Ha salido del programa Exitosamente.")
            }
            else ->{
                println("Opción incorrecta.")
            }

        }

    }
}
