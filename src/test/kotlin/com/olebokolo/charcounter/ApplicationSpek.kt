package com.olebokolo.charcounter

import com.olebokolo.charcounter.core.flatten
import com.olebokolo.charcounter.core.outputFlag
import com.olebokolo.charcounter.core.sourcesFlag
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xit
import java.io.File

object ApplicationSpek : Spek({

    describe("application") {

        val app = Application
        val resources = """src\test\resources"""
        val paths = arrayOf(
                "$resources\\some.file.txt",
                "$resources\\some.other.file.txt")
        val unexistingPaths = arrayOf(
                "$resources\\some.imaginary.file",
                "$resources\\some.other.unexisting.file")
        val outputDirectory = "${File("").absolutePath}\\out"

        it("prints info message when no sources passed") {
            app.main(arrayOf())
        }

        it("prints the same info message when passed sources flag but no sources") {
            app.main(arrayOf(sourcesFlag))
        }

        it("prints info message when no source from passed exists") {
            app.main(arrayOf(sourcesFlag, unexistingPaths).flatten())
        }

        /*
            change 'xit' to 'it' to run analysis on test resources
            and write results to file
        */
        xit("counts occurrences of chars in test resources files") {
            app.main(arrayOf(sourcesFlag, paths).flatten())
        }

        it("counts occurrences of chars in test resources files and writes them to output directory") {
            app.main(arrayOf(sourcesFlag, paths, outputFlag, outputDirectory).flatten())
        }

    }

})
