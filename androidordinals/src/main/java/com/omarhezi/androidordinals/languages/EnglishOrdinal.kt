package com.omarhezi.androidordinals.languages

import com.omarhezi.androidordinals.LanguageOrdinal

class EnglishOrdinal : LanguageOrdinal {
    override fun ordinal(number: Int): String {
        val suffix = when (number) {
            11, 12, 13 -> "th"
            else -> {
                when (number % 10) {
                    1 -> "st"
                    2 -> "nd"
                    3 -> "rd"
                    else -> "th"
                }
            }
        }

        return "$number$suffix"
    }
}