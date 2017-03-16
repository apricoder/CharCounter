package com.olebokolo.charcounter

object Analyzer {

	fun countOccurrences(line: String) = line
			.toLowerCase().toCharArray()
			.groupBy { it -> it }
			.mapValues { it.value.size }
}