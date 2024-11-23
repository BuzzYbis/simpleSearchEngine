package org.engine

import java.io.File


fun search(inputTables: ArrayList<List<String>>) {
    val found = mutableListOf<List<String>>()

    println("Enter data to search people:")
    val toSearch = readln()

    for (input in inputTables) {
        var index = 0
        for (word in input) {
            if (word.equals(toSearch, ignoreCase = true)) {
                found.add(input)
                break
            }
            index++
        }
    }

    if (found.isNotEmpty()) {
        for (people in found) {
            println(people.joinToString(" "))
        }
    } else {
        println("No matching people found.")
    }
}


fun printAll(inputTables: ArrayList<List<String>>) {
    println("=== List of people ===")

    for (people in inputTables) {
        println(people.joinToString(" "))
    }
}


fun addPerson(inputTables: ArrayList<List<String>>, filePath: String) {
    println("The new person data to add:")
    val toAdd = readln()

    File(filePath).appendText("\r$toAdd")
    inputTables.add(toAdd.split(" "))
}
