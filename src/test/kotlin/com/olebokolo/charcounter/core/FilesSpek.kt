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
                "$resources\\some.file.txt",
                "$resources\\some.other.file.txt",
                "$resources\\some.not.existing.txt")
        val emptyList = arrayListOf<String>()
        val emptyArr = arrayOf<String>()

        it("gets existing list from arguments") {
            Assertions.assertEquals(arrayListOf(
                    File("$resources\\some.file.txt"),
                    File("$resources\\some.other.file.txt")
            ), files.getExistingFiles(paths))
        }

        it("returns empty files list for empty arguments") {
            Assertions.assertEquals(emptyList, files.getExistingFiles(emptyArr))
        }

        it("normalizes file name removing directory part and extension") {
            val filename = "src\\test\\resources\\some_strange Name.txt"
            Assertions.assertEquals("some-strange-name",
                    Files.normalize(filename))
        }

        it("puts given number inside filename creating next copy") {
            Assertions.assertEquals("occurrences-from#some#(1).txt",
                    Files.getNumberedFilename("occurrences-from#some#.txt", 1))
        }
    }

})
