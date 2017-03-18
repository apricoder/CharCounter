package com.olebokolo.charcounter.core

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions

object OccurrencesSpek : Spek({

	describe("occurrences") {

		val a_1 = 'a' to 1
		val b_1 = 'b' to 1
		val b_2 = 'b' to 2
		val b_3 = 'b' to 3

		it("has extended reduce function") {
			Assertions.assertEquals(
					mapOf(a_1, b_3),
					listOf(mapOf(a_1, b_1), mapOf(b_2)).reduce())
		}

	}

})
