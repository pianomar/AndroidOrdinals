package com.omarhezi.androidordinals.languages

import com.omarhezi.androidordinals.LanguageOrdinal
import com.omarhezi.androidordinals.Ordinal

class ArabicOrdinal(private val gender: Ordinal.Gender? = null) : LanguageOrdinal {
    override fun ordinal(number: Int): String {
        if (number <= 10) return handleSingleDigit(number)

        val numberTenthModulus = number % 10

        val firstDigit = when (numberTenthModulus) {
            1 -> "الحادي"
            else -> handleSingleDigit(numberTenthModulus)
        }

        var secondDigit = when (number - numberTenthModulus) {
            10 -> " عشر"
            20 -> " و العشرون"
            30 -> " و الثلاثون"
            40 -> " و الأربعون"
            50 -> " و الخمسون"
            60 -> " و الستون"
            70 -> " و السبعون"
            80 -> " و الثمانون"
            90 -> " و التسعون"
            else -> ""
        }

        if (numberTenthModulus == 0) secondDigit = secondDigit.substring(3)

        return "$firstDigit$secondDigit"
    }

    private fun handleSingleDigit(number: Int) =
        when (number) {
            1 -> if (gender == Ordinal.Gender.MALE) "الأول" else "الأولى"
            2 -> if (gender == Ordinal.Gender.MALE) "الثاني" else "الثانية"
            3 -> if (gender == Ordinal.Gender.MALE) "الثالث" else "الثالثة"
            4 -> if (gender == Ordinal.Gender.MALE) "الرابع" else "الرابعة"
            5 -> if (gender == Ordinal.Gender.MALE) "الخامس" else "الخامسة"
            6 -> if (gender == Ordinal.Gender.MALE) "السادس" else "السادسة"
            7 -> if (gender == Ordinal.Gender.MALE) "السابع" else "السابعة"
            8 -> if (gender == Ordinal.Gender.MALE) "الثامن" else "الثامنة"
            9 -> if (gender == Ordinal.Gender.MALE) "التاسع" else "التاسعة"
            10 -> if (gender == Ordinal.Gender.MALE) "العاشر" else "العاشرة"
            else -> ""
        }
}