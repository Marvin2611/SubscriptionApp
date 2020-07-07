package com.example.abomanager

import androidx.compose.Model
import java.util.*
import java.util.Collections.list

@Model
class MainViewModel {
    //This should maybe be read from a file
    val list = mutableListOf<AboViewModel>()
    val abos = AboList(list)
    val stats = Calculator(list)

    constructor() {
        list.add(AboViewModel("Netflix", 30,15.99, Calendar.getInstance().getTime(),1,"#053225"))
        UpdateAbo(list[list.count()-1])
        list.add(AboViewModel("Amazon Prime", 365,34.99, Calendar.getInstance().getTime(),1,"#053225"))
        UpdateAbo(list[list.count()-1])
        list.add(AboViewModel("Wakanim", 90,13.99, Calendar.getInstance().getTime(),1,"#053225"))
        UpdateAbo(list[list.count()-1])
        list.add(AboViewModel("Crunchyroll", 365,39.99, Calendar.getInstance().getTime(),1,"#053225"))
        UpdateAbo(list[list.count()-1])
        list.add(AboViewModel("Disney+", 30,6.99, Calendar.getInstance().getTime(),1,"#053225"))
        UpdateAbo(list[list.count()-1])


        list.forEach {
           UpdateAbo(it)
        }
    }

    fun UpdateList() {

    }

    fun UpdateAbo(abo: AboViewModel) {
        stats.CostPerYear(abo)
        stats.CostPerDay(abo)
        stats.CostPerMonth(abo)
        stats.CostPerWeek(abo)
        stats.GetPercentages(abo)
        stats.TotalSumPerDay()
        stats.GetHighest(abo)
        stats.GetLowest(abo)
        stats.GetPercentages(abo)
        stats.GetAverage()

    }
}