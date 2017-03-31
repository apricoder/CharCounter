package com.olebokolo.charcounter

import com.olebokolo.charcounter.core.flatten
import org.junit.jupiter.api.Assertions

object CustomAssertions {

  fun assertMapsEqual(expectedMap: Map<*, *>, argumentsMap: Map<*, *>) {
    Assertions.assertEquals(expectedMap.keys, argumentsMap.keys)
    Assertions.assertEquals(expectedMap.values.flatten<String>(),
        argumentsMap.values.flatten<String>())
  }

}