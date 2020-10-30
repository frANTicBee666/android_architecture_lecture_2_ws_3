package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {

    var backButton: Button? = null
    var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        backButton = findViewById(R.id.second_layout_back_button)
        backButton?.setOnClickListener {
            onBackPressed()
        }

        editText = findViewById(R.id.second_layout_edit_text)
        editText?.setText(getTransmittedDataFromIntent() ?: DEFAULT_STRING_FOR_EDIT_TEXT)
    }

    private fun getTransmittedDataFromIntent(): String? {
        return intent.getStringExtra(TRANSMITTED_STRING)
    }

    companion object {
        const val TRANSMITTED_STRING = "transmittedString"
        const val DEFAULT_STRING_FOR_EDIT_TEXT = "default text"
    }

}