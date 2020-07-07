package com.example.subscriptionapp

import java.util.Date
import java.util.Calendar

//OLD CLASS OUTDATED USE AboViewModel sds
class Abo{
    public var name : String = ""                                     //Name of the abonnement
    public var abo_variant : Int = -1                                 //Period time span in days
    public var cost : Double = 0.0                                    //The amount needed to be paid per period
    public var starting_day : Date = Calendar.getInstance().getTime() //The abonnement starting day
    public var run_time : Int = 1                                     //The runtime in given periods
    public var color : String = "FFFFFF"                              //Color is given in hexadecimal

    //region "Add Functionality"
    public fun add_Name(name : String){
        this.name = name;
    }

    public fun add_Abo_Variant(choice : Int){
        if(choice in 1..10000){
            abo_variant = choice
        }
        else{
            throw error("Time span can't be negative or that long")
        }
    }

    public fun add_Cost(amount : Double){
        if(amount in 0.01..10000.0){
            cost = amount
        }
        else{
            throw error("Amount can't be negative or that high")
        }
    }

    public fun add_Starting_Day(begin : Date){
        starting_day = begin
    }

    public fun add_Run_Time(periods : Int){
        if(periods in 1..10000){
            run_time = periods
        }
        else{
            throw error("Periods can't be negative or that many");
        }
    }

    public fun add_Color(hex : String){
        //Check ist unvollstaendig!
        if(hex.length == 6){
            color = hex
        }
        else{
            throw error("Invalid hexadecimal code length")
        }
    }
    //endregion
}