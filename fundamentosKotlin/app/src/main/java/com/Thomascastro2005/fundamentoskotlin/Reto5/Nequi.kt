package com.Thomascastro2005.fundamentoskotlin.Reto5


class Nequi(private val numCelular: String, private val clave: String) {

    private var saldo: Double = 4500.0
    private var intentos: Int = 4


    fun mostrarSaldo(){
        println("El saldo actual es de: $saldo pesos")
    }


    fun validarInicio(): Boolean{
        while (intentos > 0){

            println("Ingrese el número de célular para ingresar")
            val numCelular = readLine()!!.toString()
            println("Ingrese la clave para ingresar")
            val clave = readLine()!!.toString()

            if (numCelular == this.numCelular && clave == this.clave) {
                return true
            }else{

                intentos --
                if (numCelular != this.numCelular ){
                    println("El numero de celular no es correcto")
                }
                if (clave != this.clave){
                    println("La clave de la cuenta no es correcta")
                }
                println("tienes $intentos intentos restantes")
            }
        }

        println("Se acabaron los intentos, vuelve más tarde")
        return false
    }


    private fun generarCodigoRetiro(): Int {
        return (100000..999999).random()
    }

    fun sacar(){
        println("Tienes 2 opciones: \n 1. Cajero \n 2. Punto físico")
        println("Ingresa la opción")
        var opcion: Int = readLine()!!.toInt()
        while (opcion !in 1..2){
            println("Opcion incorrecta, digita una que sea válida para continuar")
            opcion = readLine()!!.toInt()
        }
        val lugarRetiro = if (opcion == 1) "Cajero" else "Punto físico"
        if(this.saldo < 2000){
            println("No te alcanza")
        }else{
            println("Usted ha escogido retirar en un $lugarRetiro")
            println("¿Cuánto desea retirar?")
            var retirar: Double = readLine()!!.toDouble()
            while(retirar > this.saldo){
                println("El dinero que usted quiere retirar es mayor al saldo actual. \n Por favor ingrese una cantidad correcta retirar ")
                retirar = readLine()!!.toDouble()
            }
            while(retirar <= 0){
                println("El dinero que usted quiere retirar es 0 o menor a 0 \n Por favor ingrese una cantidad correcta para retirar")
                retirar = readLine()!!.toDouble()
            }
            this.saldo -= retirar
            println("El monto a retirar es de $retirar, su codigo para retirar es ${generarCodigoRetiro()}")
            println("Saldo actual: $saldo")
        }

    }


    fun enviar(){
        println("Ingrese el número de teléfono al que desea enviar dinero")
        val numCelularEnviar: String = readLine()!!.toString()
        println("Ingrese la cantidad de dinero a enviar")
        var enviar: Double = readLine()!!.toDouble()
        while(enviar > this.saldo){
            println("No es posible enviar el dinero, la cantidad a envíar excede el saldo actual. Ingrese una cantidad adecuada")
            enviar = readLine()!!.toDouble()
        }
        println("Se ha enviado $enviar pesos al número $numCelularEnviar")
        this.saldo -= enviar
        println("Saldo actual: $saldo")
    }


    fun recargar(){
        println("Ingrese el valor a recargar")
        val recargar: Double = readLine()!!.toDouble()
        do {
            println("¿Desea confirmar la recarga? \n 1. Si \n 2. No")
            val confirmacionRecar: Int = readLine()!!.toInt()
            if(confirmacionRecar == 1){
                println("La recarga se ha realizado con exito")
                this.saldo += recargar
            } else{
                println("Usted ha decidido no confimar la recarga")
            }
        }while(confirmacionRecar != 1 && confirmacionRecar !=2)
        println("Saldo actual: $saldo")
    }
}

fun main() {
    val numCelular = "3212345678"
    val clave = "1234"
    val nequi = Nequi(numCelular, clave)
    var salir = false
    if (nequi.validarInicio()){
        do {
            nequi.mostrarSaldo()
            println("Seleccione una opción:")
            println("1. Sacar dinero")
            println("2. Enviar dinero")
            println("3. Recargar")
            println("4. Salir")
            val opcion = readLine()!!.toInt()
            when(opcion){
                1 -> {
                    nequi.sacar()
                }
                2 -> {
                    nequi.enviar()
                }
                3 -> {
                    nequi.recargar()
                }
                4 -> {
                    println("Has decido salir de la cuenta Nequi")
                    salir = true
                }
                else -> println("Opcion incorrecta")
            }
        }while(!salir)
    }
    println("Fin del programa")
}