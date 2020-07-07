package com.example.subscriptionapp

import java.util.Collections
import java.util.Collections.list

class AboList(val aboList: MutableList<AboViewModel>) {

    public fun addAbo(abo: AboViewModel){
        aboList.add(abo)
    }

    public fun removeAbo(aboName: String){
        var zaehler: Int = 0

        for(AboViewModel in aboList){
            zaehler++

            if(AboViewModel.name == aboName) {
                zaehler
                break;
            }
        }

        if(zaehler != -1){
            aboList.removeAt(zaehler);
        }
    }
}