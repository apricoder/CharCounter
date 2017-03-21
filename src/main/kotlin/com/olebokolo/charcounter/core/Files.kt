package com.olebokolo.charcounter.core

import java.io.File

typealias Filename = String

object Files {

    /*
        Matches everything between # and .txt including.
        Example: occurrences#some-file-names{# (2).txt}
        Curly braced text will be found by regex
    */
    val suffixRegex = Regex(""".+#.+(#.*\.txt)""")

    fun getExistingFiles(names: Array<Filename>): List<java.io.File> =
            names.map(::File).filter(File::exists)

    fun getTargetFilename(sources: Collection<File>): String {
        val target = getExpectedTargetFilename(sources)
        if (!File(target).exists()) return target
        else return getNextFreeNumberedName(target)
    }

    private fun getNextFreeNumberedName(target: String): String {
        var index = 1
        var file: File
        do {
            file = getNumberedCopy(target, index)
            index += 1
        } while (file.exists())
        return file.name
    }

    private fun getNumberedCopy(target: String, number: Int) =
            File(getNumberedFilename(target, number))

    fun getNumberedFilename(target: String, number: Int): String {
        val suffix = suffixRegex.matchEntire(target)?.groups?.get(1)?.value
        return target.replace(suffix!!, "#($number).txt")
    }

    private fun getExpectedTargetFilename(sources: Collection<File>): String {
        val sourceList = sources.map { it.name }.map { normalize(it) }
        return "occurrences-from#${sourceList.reduce { acc, name ->
            "$acc.${normalize(name)}"
        }}#.txt"
    }

    fun normalize(name: Filename): String = File(name)
            .nameWithoutExtension
            .toLowerCase()
            .replace(" ", "-")
            .replace("_", "-")
            .replace(".", "-")
}
