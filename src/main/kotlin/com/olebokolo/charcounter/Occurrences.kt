package com.olebokolo.charcounter

typealias Occurrences = Map<Char, Int>

fun List<Occurrences>.reduce() =
		this.reduce { acc, occ ->
			(acc.toList() + occ.toList()).map {
				val accumulated = acc[it.first] ?: 0
				val next = occ[it.first] ?: 0
				Pair(it.first, accumulated + next)
			}.toMap()
		}
