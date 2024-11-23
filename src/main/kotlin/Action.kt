package org.engine


fun search(inputTables: List<List<String>>) {
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

    choseAction(inputTables)
}


fun printAll(inputTables: List<List<String>>) {
    println("=== List of people ===")

    for (people in inputTables) {
        println(people.joinToString(" "))
    }

    choseAction(inputTables)
}