package org.engine

import kotlin.system.exitProcess


fun choseAction(inputTables: List<List<String>>) {
    println("""
        === Menu === 
        1. Find a person
        2. Print all people
        0. Exit
        """.trimIndent())

    var nextAction = 0
    try {
        nextAction = readln().toInt()
    } catch (ignored: NumberFormatException) {
        println("You need to enter a number!")
        choseAction(inputTables)
    }

    if (nextAction == 0) {
        println("Bye!")
        exitProcess(0)
    } else if (nextAction == 1) {
        search(inputTables)
    } else if (nextAction == 2) {
        printAll(inputTables)
    } else {
        println("Incorrect option! Try again.")
        choseAction(inputTables)
    }
}
