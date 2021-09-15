package com.epicdevler.bitcoinconverter

import android.text.Editable

//
//fun main() {
//    println(Converter().convert(103073000))
//}

class Converter() {
    fun convert(inputValue: Editable): Double {

//        As at development time Bitcoin rate to One NGN was (4.7e-8)
        val convertRate = 19778729.13

//        Convert user value to string then to double
        var rate = inputValue.toString().toDoubleOrNull()?.div(convertRate)
        return String.format("%.2f", rate).toDouble()
//
    }

}