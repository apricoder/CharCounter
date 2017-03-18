package com.olebokolo.charcounter

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object ApplicationSpek : Spek({

	describe("application") {

		val app = Application
		val resources = """src\test\resources"""
		val paths = arrayOf(
				"$resources\\some.file.txt",
				"$resources\\some.other.file.txt")

		it("counts occurrences of chars in test resources files without throwing any exception") {
			app.main(paths)
		}

	}

})
