package com.example.abomanager

import kotlin.math.round

class Calculator(abos: List<AboViewModel>) {
    val list = abos
    var average: Double = -1.0
    var highest: Double = -1.0
    var lowest: Double = -1.0
    var TotalSum:Double=-1.0



    //Even out the subscriptions
    fun TotalSumPerDay(){
        var tmp:Double=0.0
        list.forEach {
            //Compare Highest with tmp
            tmp+=it.costsPerDay;
        }
        TotalSum=tmp;
    }
    fun AboCount():Int{
        return list.size
    }

    //The cost from one subscription in the complete period
    fun CostPerDay(abo: AboViewModel){
        abo.costsPerDay=abo.cost/abo.abo_variant
    }


    fun CostPerWeek(abo: AboViewModel){
        abo.costsPerWeek=abo.costsPerDay*7
    }

    fun CostPerMonth(abo: AboViewModel){
        abo.costsPerMonth=abo.costsPerDay*30
    }

    fun CostPerYear(abo: AboViewModel){
        abo.costsPerYear=abo.costsPerDay*360
    }

    //The subscription with the highest cost
    fun GetLowest(abo:AboViewModel):Double{
        var tmp: Double = abo.costsPerMonth
        list.forEach {
            //Compare Highest with tmp
            if(tmp>it.costsPerMonth){
                tmp=it.costsPerMonth
            }
        }
        lowest=tmp
        return tmp
    }

    //The subscription with the lowest cost
    fun GetHighest(abo:AboViewModel):Double{
        var tmp: Double = abo.costsPerMonth
        list.forEach {
            if(tmp<it.costsPerMonth){
                tmp=it.costsPerMonth
            }
        }
        highest=tmp
        return tmp
    }

    //Average from all subscriptions
    fun GetAverage():Double{
        var tmp:Double=0.0
        list.forEach {
            tmp+=it.costsPerMonth
            }
        average=tmp/list.size
        return tmp/list.size
    }
    //Percentile in a list from each subscription
    fun GetPercentages(abo:AboViewModel){
        var tmp:Double=0.0
        list.forEach {
            tmp+=it.costsPerDay
            abo.PercentageCost=100/tmp*abo.costsPerDay
        }
    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }
}

