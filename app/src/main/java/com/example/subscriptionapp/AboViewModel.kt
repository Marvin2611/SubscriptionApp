package com.example.abomanager

import java.util.*

data class AboViewModel(
    var name: String,
    var abo_variant : Int = -1,
    var cost : Double = 0.0,
    var starting_day : Date = Calendar.getInstance().getTime(),
    var run_time : Int = 1,
    var color : String = "#FFFFFF",
    //ResultsFromCalculator
    var costsPerDay:Double=0.0,
    var costsPerWeek:Double=0.0,
    var costsPerMonth:Double=0.0,
    var costsPerYear:Double=0.0,
    var PercentageCost:Double=0.0

    ) {
}