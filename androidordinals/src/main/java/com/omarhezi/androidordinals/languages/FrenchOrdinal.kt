package com.omarhezi.androidordinals.languages

import com.omarhezi.androidordinals.LanguageOrdinal

class FrenchOrdinal : LanguageOrdinal {
    override fun ordinal(number: Int) : String {
        return when (number) {
            1 -> "${number}er"
            else -> "${number}e"
        }
    }
}