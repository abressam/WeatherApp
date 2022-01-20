package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // call the function to print the celsius temperature on the screen when initialize the app
        convertToCelsius()

        val fahrenheit: ImageButton = findViewById(R.id.fahrenheit_button)
        fahrenheit.setOnClickListener { convertToFahrenheit() }

        val celsius: ImageButton = findViewById(R.id.celsius_button)
        celsius.setOnClickListener { convertToCelsius() }
    }

    private fun convertToCelsius() {
        val fahrenheitTemperature = Temperature(0)
        val changeFahrenheit = fahrenheitTemperature.fahrenheitToCelsius()

        val celsiusTextView: TextView = findViewById(R.id.main_temperature)
        celsiusTextView.text = changeFahrenheit.toString()

        val celsiusSymbolTextView: TextView = findViewById(R.id.temperature_symbol)
        val celsiusSymbolString: String = getString(R.string.celsius_symbol)
        celsiusSymbolTextView.text = celsiusSymbolString
    }

    private fun convertToFahrenheit() {
        val celsiusTemperature = Temperature(0)
        val changeCelsius = celsiusTemperature.celsiusToFahrenheit()

        val fahrenheitTextView: TextView = findViewById(R.id.main_temperature)
        fahrenheitTextView.text = changeCelsius.toString()

        val fahrenheitSymbolTextView: TextView = findViewById(R.id.temperature_symbol)
        val fahrenheitSymbolString: String = getString(R.string.fahrenheit_symbol)
        fahrenheitSymbolTextView.text = fahrenheitSymbolString
    }
}

class Temperature(private val inputTemperature: Int) {
    fun celsiusToFahrenheit(): Int {
        // equation: (°C * (9/5) + 32) = °F
        return (inputTemperature * (9/5) + 32)
    }

    fun fahrenheitToCelsius(): Int {
        // equation: ((°F - 32) * (5/9)) = °C
        return ((inputTemperature - 32) * (5/9))
    }
}