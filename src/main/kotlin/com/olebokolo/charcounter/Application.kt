package com.olebokolo.charcounter

object Application {
	@JvmStatic
	fun main(arguments: Array<String>) {
		Analyzer.countCharOccurrences(arguments)
	}

}
