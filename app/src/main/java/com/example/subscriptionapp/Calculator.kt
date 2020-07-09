package com.example.subscriptionapp

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.round

class Calculator(abos: List<AboViewModel>) {
    val list = abos
    var average: Double = 0.0
    var highest: Double = 0.0
    var lowest: Double = 0.0
    var TotalSum:Double = 0.0

    fun RoundNumber(nmb: Double) : Double{
        val tmp = BigDecimal(nmb).setScale(2, RoundingMode.HALF_EVEN)
        return tmp.toDouble()
    }

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
        abo.costsPerDay = abo.cost/abo.abo_variant
        abo.costsPerDay = RoundNumber(abo.costsPerDay)
    }
    fun CostPerWeek(abo: AboViewModel){
        abo.costsPerWeek = abo.costsPerDay*7
        abo.costsPerWeek = RoundNumber(abo.costsPerWeek)
    }

    fun CostPerMonth(abo: AboViewModel){
        abo.costsPerMonth = abo.costsPerDay*30
        abo.costsPerMonth = RoundNumber(abo.costsPerMonth)
    }
    fun CostPerYear(abo: AboViewModel){
        abo.costsPerYear = abo.costsPerDay*360
        abo.costsPerYear = RoundNumber(abo.costsPerYear)
    }
    //The subscription with the highest cost
    fun GetLowest(abo:AboViewModel):Double{
        var tmp: Double = abo.cost+0.001
        list.forEach {
            //Compare Highest with tmp
            if(tmp>it.costsPerMonth){
                tmp=it.costsPerMonth
            }
        }
        lowest = RoundNumber(tmp)
        return lowest
    }
    //The subscription with the lowest costs
    fun GetHighest():Double{
        var tmp: Double = 0.0
        list.forEach {
            if(tmp<it.costsPerMonth){
                tmp=it.costsPerMonth
            }
        }
        highest = RoundNumber(tmp)
        return highest
    }

    //Average from all subscriptions
    fun GetAverage():Double{
        var tmp:Double=0.0
        list.forEach {
            tmp+=it.costsPerMonth
            RoundNumber(tmp)
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
}

