package org.engine

import kotlin.system.exitProcess


fun choseAction(inputTables: ArrayList<String>, inputMap: MutableMap<String, List<Int>>, filePath: String) {
    println("""
        === Menu === 
        1. Find a person
        2. Print all people
        3. Add a person 
        0. Exit
        """.trimIndent())

    var nextAction = 0
    try {
        nextAction = readln().toInt()
    } catch (ignored: NumberFormatException) {
        println("You need to enter a number!")
        choseAction(inputTables, inputMap, filePath)
    }

    when (nextAction ) {
        0 -> {
            println("Bye!")
            exitProcess(0)
        }
        1 -> search(inputTables, inputMap)
        2 -> printAll(inputTables)
        3 -> addPerson(inputTables, inputMap, filePath)
        else -> println("Incorrect option! Try again.")
    }

    choseAction(inputTables, inputMap, filePath)
}
