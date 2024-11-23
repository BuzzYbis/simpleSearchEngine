package org.engine

import java.io.File


fun main(args: Array<String>) {
    val filePath = args[0]
    val inputTables = ArrayList<List<String>>()
    File(filePath).forEachLine {
        inputTables.add(it.split(" "))
    }

    choseAction(inputTables, filePath)
}
