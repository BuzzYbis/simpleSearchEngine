package org.engine


fun main() {
    println("Enter the number of people:")
    val nbEntry = readln().toInt()

    println("Enter all people:")
    val inputTables = mutableListOf<List<String>>()
    for (i in 1..nbEntry) {
        inputTables.add(readln().split(" "))
    }

    choseAction(inputTables)
}
