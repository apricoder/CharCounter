package com.olebokolo.charcounter.core

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions
import java.io.File

object FilesSpek : Spek({

	describe("files") {
		val files = Files

		val resources = """src\test\resources"""
		val paths = arrayOf(
				"$resources\\some.txt",
				"$resources\\some.other.txt",
				"$resources\\some.not.existing.txt")
		val emptyList = arrayListOf<String>()
		val emptyArr = arrayOf<String>()

		it("gets existing list from arguments") {
			Assertions.assertEquals(arrayListOf(
					File("$resources\\some.txt"),
					File("$resources\\some.other.txt")
			), files.getExistingFiles(paths))
		}

		it("returns empty files list for empty arguments") {
			Assertions.assertEquals(emptyList, files.getExistingFiles(emptyArr))
		}
	}

})
