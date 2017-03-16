package com.olebokolo.charcounter

import java.io.File

object Files {

	fun getExisting(paths: Array<String>): List<String> = paths.map(::File)
			.filter(File::exists)
			.map { it.absolutePath }
}