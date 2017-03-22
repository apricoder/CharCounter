package com.olebokolo.charcounter

import com.olebokolo.charcounter.core.Analyzer.countFilesCharOccurrences
import com.olebokolo.charcounter.core.ArgumentsParser.getArgumentsMap
import com.olebokolo.charcounter.core.Files
import com.olebokolo.charcounter.core.Files.getExistingFiles
import com.olebokolo.charcounter.core.Files.getTargetFilename
import com.olebokolo.charcounter.core.outputFlag
import com.olebokolo.charcounter.core.serialize
import com.olebokolo.charcounter.core.sourcesFlag
import java.io.File

object Application {

    @JvmStatic
    fun main(arguments: Array<String>) {
        val argumentsMap = with(arguments, ::getArgumentsMap)
        val fileNames = argumentsMap[sourcesFlag]
        val outputDirectory = argumentsMap[outputFlag]?.get(0)
        if (fileNames != null && fileNames.isNotEmpty()) {
            val existing = with(fileNames, ::getExistingFiles)
            if (existing.isNotEmpty()) analyze(existing, outputDirectory)
            else println("No existing files among passed sources")
        } else println("No sources to analyze")
    }

    private fun analyze(files: List<File>, outputDirectory: String?) {
        val occurrences = with(files, ::countFilesCharOccurrences).serialize()
        println("Occurrences:\n$occurrences")
        val targetPath = Files.getTargetFilename(files, outputDirectory)
        with(File(targetPath)) {
            if (parent != null) {
                with(File(parent)) { if (!exists()) mkdirs() }
            }
            writeText(occurrences)
        }
        println("Finished writing occurrences to $targetPath")
    }

}
