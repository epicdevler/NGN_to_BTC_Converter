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

            val userAmountInput = binding.amountValue.text

//            Check for invalid input states before making currency amount conversation
            if (userAmountInput.toString().isEmpty() ||
                userAmountInput.toString() == "0" ||
                userAmountInput.toString() == "0.0"
            ) {
//                    error state
                showErrorMsg("Invalid amount")
            } else {
                hideErrorMsg()

                bitCoinConverter = Converter()

                val bitCoinAmount = bitCoinConverter.convert(userAmountInput)

                val currencyFormatter = NumberFormat.getCurrencyInstance()
//                Replace dollar sign with bitcoin sign
                val convertedCash = currencyFormatter.format(bitCoinAmount).replace("$", "₿ ")

//                Validate the state of switch button when convert button is clicked
                if (binding.switchCompat.isChecked) {
                    binding.convertedValue.text = "₿ ${bitCoinAmount.toInt()}"

                } else {
                    binding.convertedValue.text = convertedCash
                }

            }

        }

    }

    private fun showErrorMsg(msg: String) {
        binding.errorText.visibility = VISIBLE
        binding.errorText.text = msg
    }

    private fun hideErrorMsg() {
        binding.errorText.visibility = GONE
        binding.errorText.text = ""
    }

}
