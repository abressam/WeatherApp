package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

/**
 * This activity allows the user to view the weather in your current city
 * and change the temperature between Celsius (ºC) or Fahrenheit (ºF).
*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call the function to print the celsius temperature on the screen when the app starts
        convertToCelsius()

        // Find the fahrenheit button in the layout
        val fahrenheit: ImageButton = findViewById(R.id.fahrenheit_button)

        /**
         *  When the fahrenheit button is clicked will convert the temperature
         *  to fahrenheit and change the drawable symbol
         */
        fahrenheit.setOnClickListener {
            convertToFahrenheit()
            changeSymbolToFahrenheit()
        }

        // Find the celsius button in the layout
        val celsius: ImageButton = findViewById(R.id.celsius_button)

        /**
         *  When the celsius button is clicked will convert the temperature
         *  to celsius and change the drawable symbol
         */
        celsius.setOnClickListener {
            convertToCelsius()
            changeSymbolToCelsius()
        }
    }

    /**
     *  This function change the celsius symbol
     *  into a full white circle with an ºC inside
     */
    private fun changeSymbolToCelsius() {
        // Find the celsius button on the layout
        val celsiusSymbol: ImageButton = findViewById(R.id.celsius_button)

        // Change the drawable of the celsius button - "Celsius button is activated"
        celsiusSymbol.setImageResource(R.drawable.celsius_with_circle)

        // Find the fahrenheit button on the layout
        val fahrenheitSymbol: ImageButton = findViewById(R.id.fahrenheit_button)

        // Change the drawable of the fahrenheit button - "Fahrenheit button is not activated"
        fahrenheitSymbol.setImageResource(R.drawable.fahrenheit_without_circle)
    }

    /**
     * This function change the fahrenheit symbol
     * into a full white circle with an ºF inside
     */
    private fun changeSymbolToFahrenheit() {
        // Find the fahrenheit button on the layout
        val fahrenheitSymbol: ImageButton = findViewById(R.id.fahrenheit_button)

        // Change the drawable of the fahrenheit button - "Fahrenheit button is activated"
        fahrenheitSymbol.setImageResource(R.drawable.fahrenheit_with_circle)

        // Find the celsius button on the layout
        val celsiusSymbol: ImageButton = findViewById(R.id.celsius_button)

        // Change the drawable of the celsius button - "Celsius button is not activated"
        celsiusSymbol.setImageResource(R.drawable.celsius_without_circle)
    }

    /**
     * This function convert the temperature to celsius
     * and update the screen with the result
     * */
    private fun convertToCelsius() {
        // Created fahrenheit temperature
        val fahrenheitTemperature = Temperature(0)

        // Call the fahrenheitToCelsius() method and save the result in the changeFahrenheit variable
        val changeFahrenheit = fahrenheitTemperature.fahrenheitToCelsius()

        // Find the main temperature in the layout
        val celsiusTextView: TextView = findViewById(R.id.main_temperature)

        // Using toString() to convert the Int into String
        celsiusTextView.text = changeFahrenheit.toString()

        // Find the temperature symbol in the layout
        val celsiusSymbolTextView: TextView = findViewById(R.id.temperature_symbol)

        // Get string celsius symbol
        val celsiusSymbolString: String = getString(R.string.celsius_symbol)

        // Update the celsius string
        celsiusSymbolTextView.text = celsiusSymbolString
    }

    /**
     * This function convert the temperature to fahrenheit
     * and update the screen with the result
     * */
    private fun convertToFahrenheit() {
        // Created celsius temperature
        val celsiusTemperature = Temperature(0)

        // Call the celsiusToCelsius() method and save the result in the changeCelsius variable
        val changeCelsius = celsiusTemperature.celsiusToFahrenheit()

        // Find the main temperature in the layout
        val fahrenheitTextView: TextView = findViewById(R.id.main_temperature)

        // Using toString() to convert the Int into String
        fahrenheitTextView.text = changeCelsius.toString()

        // Find the temperature symbol in the layout
        val fahrenheitSymbolTextView: TextView = findViewById(R.id.temperature_symbol)

        // Get string fahrenheit symbol
        val fahrenheitSymbolString: String = getString(R.string.fahrenheit_symbol)

        // Update the fahrenheit string
        fahrenheitSymbolTextView.text = fahrenheitSymbolString
    }
}

/**
 * This class calculate the temperature in celsius
 * and fahrenheit
 * */
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