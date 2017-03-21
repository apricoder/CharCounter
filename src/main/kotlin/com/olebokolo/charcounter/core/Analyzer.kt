package com.olebokolo.charcounter.core

import java.io.File

object Analyzer {

    fun countFilesCharOccurrences(files: List<File>): Occurrences = files
            .map { countFileCharOccurrences(it) }
            .reduce()

    fun countFileCharOccurrences(file: File): Occurrences = file
            .readLines().map { countCharOccurrences(it) }
            .reduce()

    fun countCharOccurrences(line: String) = line
            .toLowerCase().toCharArray()
            .groupBy { it -> it }
            .mapValues { it.value.size }
}
