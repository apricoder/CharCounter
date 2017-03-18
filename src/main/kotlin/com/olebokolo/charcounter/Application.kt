package com.olebokolo.charcounter

import com.olebokolo.charcounter.core.Analyzer
import com.olebokolo.charcounter.core.Files

object Application {
	@JvmStatic
	fun main(arguments: Array<String>) {
		Analyzer.countFilesCharOccurrences(Files.getExistingFiles(arguments))
	}

}
