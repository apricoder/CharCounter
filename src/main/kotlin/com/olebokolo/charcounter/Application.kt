package com.olebokolo.charcounter

import com.olebokolo.charcounter.core.Analyzer.countFilesCharOccurrences
import com.olebokolo.charcounter.core.Files.getExistingFiles
import com.olebokolo.charcounter.core.Files.getTargetFilename
import com.olebokolo.charcounter.core.serialize
import java.io.File

object Application {

    @JvmStatic
    fun main(arguments: Array<String>) {
        val files = with(arguments, ::getExistingFiles)
        if (files.isNotEmpty()) analyze(files)
        else println("No files to analyze")
    }

    private fun analyze(files: List<File>) {
        val occurrences = with(files, ::countFilesCharOccurrences).serialize()
        println("Occurrences:\n$occurrences")
        val target = with(files, ::getTargetFilename)
        File(target).writeText(occurrences)
        println("Finished writing occurrences to $target")
    }

}
