package com.example.subscriptionapp

import androidx.lifecycle.ViewModel
import java.util.*
import java.util.Collections.list

class MainViewModel : ViewModel(){
    //This should maybe be read from a file add
    var list = mutableListOf<AboViewModel>()
    var abos = AboList(list)
    var stats = Calculator(list)

    /*constructor() {
        list.add(AboViewModel("Netflix", 30,15.99, Calendar.getInstance().getTime(),1,"#053225"))
        updateAbo(list[list.count()-1])
        list.add(AboViewModel("Amazon Prime", 365,34.99, Calendar.getInstance().getTime(),1,"#053225"))
        updateAbo(list[list.count()-1])
        list.add(AboViewModel("Wakanim", 90,13.99, Calendar.getInstance().getTime(),1,"#053225"))
        updateAbo(list[list.count()-1])
        list.add(AboViewModel("Crunchyroll", 365,39.99, Calendar.getInstance().getTime(),1,"#053225"))
        updateAbo(list[list.count()-1])
        list.add(AboViewModel("Disney+", 30,6.99, Calendar.getInstance().getTime(),1,"#053225"))
        updateAbo(list[list.count()-1])


        list.forEach {
           updateAbo(it)
        }
    }*/

    fun updateList() {

    }

    fun updateAbo(abo: AboViewModel) {
        stats.CostPerYear(abo)
        stats.CostPerDay(abo)
        stats.CostPerMonth(abo)
        stats.CostPerWeek(abo)
        stats.GetPercentages(abo)
        stats.TotalSumPerDay()
        stats.GetHighest()
        stats.GetLowest(abo)
        stats.GetPercentages(abo)
        stats.GetAverage()
    }
}