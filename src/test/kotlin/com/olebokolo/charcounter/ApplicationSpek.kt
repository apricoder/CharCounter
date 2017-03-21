package com.olebokolo.charcounter

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xit

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

        /*
            change 'xit' to 'it' to run analysis on test resources
            and write results to file in project folder
        */
        xit("counts occurrences of chars in test resources files") {
            app.main(paths)
        }

    }

})
