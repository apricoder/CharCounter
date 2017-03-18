package com.olebokolo.charcounter.core

import java.io.File

object Files {

	fun getExistingFiles(paths: Array<String>): List<java.io.File>
			= paths.map(::File).filter(File::exists)
}
