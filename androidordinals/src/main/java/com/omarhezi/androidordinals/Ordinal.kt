package com.omarhezi.androidordinals

import com.omarhezi.androidordinals.languages.ArabicOrdinal
import com.omarhezi.androidordinals.languages.EnglishOrdinal
import com.omarhezi.androidordinals.languages.FrenchOrdinal
import com.omarhezi.androidordinals.languages.SpanishOrdinal
import java.util.*

class Ordinal(private val languageISO3Code: String? = null) {

    enum class Gender {
        MALE, FEMALE
    }

    private var languages = mapOf<String, Locale>()

    init {
        languages = Languages.getLanguages()
    }

    fun ordinal(number: Int, languageISO3Code: String? = this.languageISO3Code, gender: Gender? = null): String {
        checkIsValidLanguage(languageISO3Code)

        try {
            val languageClass = when (languageISO3Code) {
                "eng" -> EnglishOrdinal()
                "esp" -> SpanishOrdinal()
                "fre" -> FrenchOrdinal()
                "ara" -> ArabicOrdinal(gender)
                else -> null
            }

            return languageClass?.ordinal(number).orEmpty()
        } catch (exception: Exception) {
            error(exception)
        }
    }

    private fun checkIsValidLanguage(languageISO3Code: String?) {
        if (!languages.containsKey(languageISO3Code)) {
            error("languageISO3Code passed is not an ISO language code")
        }
    }
}

object Languages {
    fun getLanguages(): MutableMap<String, Locale> {
        val languages = Locale.getISOLanguages()
        val localeMap: MutableMap<String, Locale> = HashMap(languages.size)
        for (language in languages) {
            val locale = Locale(language)
            localeMap[locale.isO3Language] = locale
        }

        return localeMap
    }
}