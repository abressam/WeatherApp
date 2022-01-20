package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fahrenheit: ImageButton = findViewById(R.id.imageButton)
        fahrenheit.setOnClickListener { convertTemperature() }
    }

    private fun convertTemperature() {
        val temperature = Temperature(24)
        val changeTemperature = temperature.celsiusToFahrenheit()

        val fahrenheitTextView: TextView = findViewById(R.id.main_temperature)
        fahrenheitTextView.text = changeTemperature.toString()

        val symbolTextView: TextView = findViewById(R.id.fahrenheit_symbol)
        val symbolString: String = getString(R.string.fahrenheit_symbol)
        symbolTextView.text = symbolString
    }
}

class Temperature(val inputTemperature: Int) {
    fun celsiusToFahrenheit(): Int {
        // equation: (°C * (9/5) + 32) = °F
        return (inputTemperature * (9/5) + 32)
    }

    fun fahrenheitToCelsius(): Int {
        // equation: ((°F - 32) * (5/9)) = °C
        return ((inputTemperature - 32) * (5/9))
    }
}