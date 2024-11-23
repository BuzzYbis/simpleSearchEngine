package org.engine

import java.io.File


fun search(inputList: ArrayList<String>, inputMap: Map<String, List<Int>>) {
    println("""
        === Possible search strategy ===
        ANY - prints the lines containing at least one word from the query  
        ALL - prints the lines containing all the word from the query 
        NONE - prints all the lines not containing the words from the query 
        """.trimIndent())

    val nextAction = readln()
    if (!(nextAction.uppercase() == "ANY" || nextAction.uppercase() == "ALL" || nextAction.uppercase() == "NONE")) {
        println("You need to enter a a valid option: ANY, ALL or NONE")
        search(inputList, inputMap)
    }

    println("Enter data to search people:")
    val toSearch = readln().split(" ")

    if (nextAction.uppercase() == "ANY") {
        var found = false
        for (query in toSearch) {
            if (query.lowercase() in inputMap) {
                found = true
                for (i in inputMap[query.lowercase()]!!) {
                    println(inputList[i])
                }
            }
        }

        if (!found) {
            println("No query found")
        }
    } else {
        var found: Set<Int> = (0..<inputList.size).toSet()
        for (query in toSearch) {
            if (query.lowercase() in inputMap) {
                found = found intersect inputMap[query.lowercase()]!!.toSet()
                println(found)
            }
        }

        if (nextAction.uppercase() == "ALL") {
            for (i in found) {
                println(inputList[i])
            }
        } else {
            for (i in ((0..<inputList.size) - found)) {
                println(inputList[i])
            }
        }
    }
}


fun printAll(inputList: ArrayList<String>) {
    println("=== List of people ===")

    for (people in inputList) {
        println(people)
    }
}


fun addPerson(inputList: ArrayList<String>, inputMap: MutableMap<String, List<Int>>, filePath: String) {
    println("The new person data to add:")
    val toAdd = readln()
    val line = toAdd.split(" ")

    File(filePath).appendText("\r$toAdd")
    inputList.add(toAdd)

    for (word in line) {
        if (word.lowercase() in inputMap) {
            inputMap[word.lowercase()] = (inputMap[word.lowercase()]!! + arrayListOf(inputList.size - 1))
        } else {
            inputMap[word.lowercase()] = arrayListOf(inputList.size - 1)
        }
    }
}
