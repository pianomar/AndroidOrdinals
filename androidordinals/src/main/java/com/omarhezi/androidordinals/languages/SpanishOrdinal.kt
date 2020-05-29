package com.omarhezi.androidordinals.languages

import com.omarhezi.androidordinals.LanguageOrdinal

class SpanishOrdinal : LanguageOrdinal {
    override fun ordinal(number: Int) = "$number°"
}