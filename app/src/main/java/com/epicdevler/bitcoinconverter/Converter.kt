package com.epicdevler.bitcoinconverter

import android.text.Editable
import kotlin.math.round

//
//fun main() {
//    println(Converter().convert(103073000))
//}


class Converter() {
    fun convert(inputValue: Editable): Double {

//        As at development time Bitcoin rate to One NGN was (4.7e-8)
        val convertRate = 4.7e-8

//        Convert user value to string then to double
        return round(inputValue.toString().toDouble() * convertRate)
//
    }

}