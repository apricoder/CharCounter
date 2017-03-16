package com.olebokolo.charcounter

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

object AnalyzerTest : Spek({

	describe("analyzer") {
		val analyzer = Analyzer

		val line = "Lorem ipsum dolor sit amet"
		val ignoreCaseLine = "small x occurrences sums with upper X"
		val lineWithPunctuation = "some lines, after all, should contain non letter characters..."

		it("counts every char occurrences") {
			val occurrences = analyzer.countOccurrences(line)
			Assertions.assertEquals(2, occurrences['l'])
			Assertions.assertEquals(3, occurrences['o'])
			Assertions.assertEquals(4, occurrences[' '])
		}

		it("ignores case counting") {
			val occurrences = analyzer.countOccurrences(ignoreCaseLine)
			Assertions.assertEquals(2, occurrences['x'])
		}

		it("counts punctuation chars as well") {
			val occurrences = analyzer.countOccurrences(lineWithPunctuation)
			Assertions.assertEquals(2, occurrences[','])
			Assertions.assertEquals(3, occurrences['.'])
		}
	}
})