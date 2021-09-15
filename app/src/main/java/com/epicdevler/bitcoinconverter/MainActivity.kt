package com.epicdevler.bitcoinconverter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.epicdevler.bitcoinconverter.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var bitCoinConverter: Converter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertBtn.setOnClickListener {

            val userAmountInput = binding.amountValue.text.toString().toDoubleOrNull()

            if (userAmountInput == null || userAmountInput == 0.00) {
                displayConversion(0.00)
                return@setOnClickListener
            }
            var converter = Converter()

//            MAKE CONVERSION
            var convert = converter.convert(binding.amountValue.text)
            if (binding.switchCompat.isChecked) {
                convert = convert.let { kotlin.math.round(it) }
            }
            displayConversion(convert)
        }

    }

    private fun displayConversion(convert: Double) {
        binding.convertedValue.text =
            NumberFormat.getNumberInstance().format(convert)
    }

}
