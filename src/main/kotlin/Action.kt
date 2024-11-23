package org.engine

import java.io.File


fun search(inputList: ArrayList<String>, inputMap: Map<String, List<Int>>) {
    println("Enter data to search people:")
    val toSearch = readln()

    if (toSearch.lowercase() in inputMap) {
        for (i in inputMap[toSearch]!!) {
            println(inputList[i])
        }
    } else {
        println("No matching people found.")
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
