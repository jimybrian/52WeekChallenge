package com.outreach.fiftytwoweekchallenge

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeekViewModel : ViewModel() {

    //Holds the users input
    var amount: MutableLiveData<String> = MutableLiveData()

    //holds the total for all weeks
    var totalAmount : MutableLiveData<String> = MutableLiveData()

    //Update the weeks being calculated
    fun updateWeeks(amount: String) : List<WeekItem>{
        var lsWeeks: MutableList<WeekItem> = ArrayList()

        var total = 0
        for(i in 1..52){
            val deposit = i * amount.toInt()
            total += deposit
            val week = WeekItem("Week ${i.toString()}",
                "Total : KES ${total.toString()}",
                "Deposit : KES ${deposit.toString()}")
            lsWeeks.add(week)
        }
        totalAmount.value = "Total : ${total.toString()}"
        return lsWeeks
    }

    //Restrict user input to between 1 and 100000
    fun amountValidation(amount: String) : Boolean {
        return amount.toInt() in 1..100000
    }

}