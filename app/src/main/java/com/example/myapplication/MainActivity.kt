package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // кнопка перехода на следующую активити
    var nextButton: Button? = null
    // Поле ввода данных в главной активити
    var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация переменной кнопки перехода
        nextButton = findViewById(R.id.main_layout_next_button)
        // Добавление обработчика нажатия кнопки
        nextButton?.setOnClickListener {
            moveToNextScreen()
        }

        // Инициализация переменной поля ввода
        editText = findViewById(R.id.main_layout_edit_text)
    }

    // Получение текста из поля ввода данных
    fun getStringFromEditText(): String? {
        return editText?.text?.toString()
    }

    // Переход на следующий экран
    fun moveToNextScreen() {
        // Создание интента перехода
        val intent = Intent(this, SecondActivity::class.java)

        // Добавление extra данных в интент
        intent.putExtra(TRANSMITTED_STRING, getStringFromEditText())

        // Старт второй активити
        startActivity(intent)
    }

    companion object {
        const val TRANSMITTED_STRING = "transmittedString"
    }

}