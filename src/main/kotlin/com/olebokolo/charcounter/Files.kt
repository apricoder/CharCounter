package com.olebokolo.charcounter

import java.io.File

object Files {

  fun getExisting(paths: Array<String>): List<String> {
    return paths.flatMap { path ->
      val file = File(path)
      if (file.exists()) arrayListOf(file.absolutePath)
      else arrayListOf()
    }
  }
}