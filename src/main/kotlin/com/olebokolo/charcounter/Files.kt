package com.olebokolo.charcounter

import java.io.File

object Files {

	fun getExistingFiles(paths: Array<String>): List<File>
			= paths.map(::File).filter(File::exists)
}
