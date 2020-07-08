package com.example.subscriptionapp.ui.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.subscriptionapp.R

class StatisticsFragment : Fragment() {

    private lateinit var statisticsViewModel: StatisticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        statisticsViewModel = ViewModelProviders.of(this).get(StatisticsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_statistics, container, false)

        val costPerMonthValue: TextView = root.findViewById(R.id.costPerMonthValue)
        costPerMonthValue.text = "11€"

        val costPerYearValue: TextView = root.findViewById(R.id.costPerYearValue)
        costPerYearValue.text = "132€"

        val highestValue: TextView = root.findViewById(R.id.mostExpensiveValue)
        highestValue.text = "11€"

        val lowestValue: TextView = root.findViewById(R.id.cheapestValue)
        lowestValue.text = "11€"

        val averageValue: TextView = root.findViewById(R.id.averageValue)
        averageValue.text = "11€"

        return root
    }
}