package com.example.abomanager

import java.util.Collections
import java.util.Collections.list

class AboList(val aboList: MutableList<AboViewModel>) {

    public fun AddAbo(abo: AboViewModel){
        aboList.add(abo)
    }

    public fun RemoveAbo(aboName: String){
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