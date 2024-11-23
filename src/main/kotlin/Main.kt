package org.engine

import java.io.File


fun main(args: Array<String>) {
    val filePath = args[0]
    val inputList = ArrayList<String>()
    val inputMap = mutableMapOf<String, List<Int>>()

    File(filePath).forEachLine {
        inputList.add(it)
        val line = it.split(" ")

        for (word in line) {
            if (word.lowercase() in inputMap) {
                inputMap[word.lowercase()] = (inputMap[word.lowercase()]!! + arrayListOf(inputList.size - 1))
            } else {
                inputMap[word.lowercase()] = arrayListOf(inputList.size - 1)
            }
        }
    }

    choseAction(inputList, inputMap, filePath)
}
