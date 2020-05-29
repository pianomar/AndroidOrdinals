package com.omarhezi.ordinals

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.omarhezi.androidordinals.Ordinal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ordinalObj = Ordinal("ara")

        for (index in 1..99) {
            Log.e("** + ** +", ordinalObj.ordinal(index, gender = Ordinal.Gender.MALE))
        }
    }
}
