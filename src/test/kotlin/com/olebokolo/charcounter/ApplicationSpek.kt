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

        it("prints info message when ran without params") {
            app.main(arrayOf())
        }

        it("counts occurrences of chars in test resources files") {
            app.main(paths)
        }

    }

})
