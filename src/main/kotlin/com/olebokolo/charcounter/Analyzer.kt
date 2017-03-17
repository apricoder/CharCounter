package com.olebokolo.charcounter

import java.io.File

object Analyzer {

	fun countCharOccurrences(paths: Array<String>): Occurrences = Files
			.getExistingFiles(paths)
			.map { countCharOccurrences(it) }
			.reduce()

	fun countCharOccurrences(file: File): Occurrences = file
			.readLines().map { countCharOccurrences(it) }
			.reduce()

	fun countCharOccurrences(line: String) = line
			.toLowerCase().toCharArray()
			.groupBy { it -> it }
			.mapValues { it.value.size }
}
