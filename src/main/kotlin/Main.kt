package org.engine


fun main() {
    println("Enter the number of people:")
    val nbEntry = readln().toInt()

    println("Enter all people:")
    val inputTables = mutableListOf<List<String>>()
    for (i in 1..nbEntry) {
        inputTables.add(readln().split(" "))
    }


    println("Enter the number of search queries:")
    val nbQueries = readln().toInt()

    for (i in 1..nbQueries) {
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
}
