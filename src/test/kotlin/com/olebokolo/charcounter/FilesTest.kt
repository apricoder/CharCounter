package com.olebokolo.charcounter

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

object FilesTest : Spek({

	describe("files") {
		val files = Files

		val currentFolder = File("").absolutePath
		val resources = """src\test\resources"""
		val paths = arrayOf(
				"$resources\\some.txt",
				"$resources\\some.other.txt",
				"$resources\\some.not.existing.txt")
		val emptyList = arrayListOf<String>()
		val emptyArr = arrayOf<String>()

		it("gets existing files absolute paths list from arguments") {
			Assertions.assertEquals(arrayListOf(
					"$currentFolder\\$resources\\some.txt",
					"$currentFolder\\$resources\\some.other.txt"
			), files.getExisting(paths))
		}

		it("returns empty file paths list for empty arguments") {
			Assertions.assertEquals(emptyList, files.getExisting(emptyArr))
		}
	}

})