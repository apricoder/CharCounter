package com.olebokolo.charcounter

object Application {
	@JvmStatic
	fun main(arguments: Array<String>) {
		Files.getExisting(arguments)
		print("Cool app is coming!")
	}

}