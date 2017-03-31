package com.olebokolo.charcounter.core

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions
import java.io.File

object FilesSpek : Spek({

  describe("files") {
    val files = Files

    val mocks = """src\test\resources\mocks"""
    val rawPaths = arrayOf(
        "$mocks\\some.file.txt",
        "$mocks\\some.other.file.txt",
        "$mocks\\some.not.existing.txt")
    val paths = arrayOf(
        "$mocks\\some.file.txt",
        "$mocks\\some.other.file.txt")

    val literature = "$mocks\\literature"
    val literaryWorks = arrayOf(
        "$literature\\city.txt",
        "$literature\\intermezzo.txt",
        "$literature\\land.txt",
        "$literature\\tiger-catchers.txt")

    val emptyList = arrayListOf<String>()
    val emptyArr = arrayOf<String>()

    it("gets existing list from arguments") {
      Assertions.assertEquals(arrayListOf(
          File("$mocks\\some.file.txt"),
          File("$mocks\\some.other.file.txt")
      ), files.getExistingFiles(rawPaths))
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

    it("combines target file name from passed source files") {
      Assertions.assertEquals("occurrences-from#some-file.some-other-file#.txt",
          Files.getTargetFilename(paths.map(::File)))
    }

    it("combines target file name from passed source files and target directory") {
      Assertions.assertEquals("output-directory\\occurrences-from#some-file.some-other-file#.txt",
          Files.getTargetFilename(paths.map(::File), "output-directory"))
    }

    it("mentions only 3 first sources in target filename to avoid windows max path bug") {
      val allSources = literaryWorks.flatten<String>().map(::File)
      Assertions.assertEquals("occurrences-from#city.intermezzo.land.and-more#.txt",
          Files.getTargetFilename(allSources))
    }

    it("recursively mines all sources from folder") {
      val allSources = paths.map(::File)
      Assertions.assertEquals(allSources, Files.getFiles(arrayOf(mocks)))
    }
  }

})
