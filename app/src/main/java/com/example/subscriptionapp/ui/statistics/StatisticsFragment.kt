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

class StatisticsFragment : Fragment(){

    private lateinit var statisticsViewModel: StatisticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        statisticsViewModel = ViewModelProviders.of(this).get(StatisticsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_statistics, container, false)

        val monthValue: TextView = root.findViewById(R.id.text_profile)
        statisticsViewModel.costPerMonthValue.observe(viewLifecycleOwner, Observer {
            monthValue.text = it
        })

        val yearValue: TextView = root.findViewById(R.id.text_profile)
        statisticsViewModel.costPerYearValue.observe(viewLifecycleOwner, Observer {
            yearValue.text = it
        })

        val mostExpensiveValue: TextView = root.findViewById(R.id.text_profile)
        statisticsViewModel.costOfMostExpensiveValue.observe(viewLifecycleOwner, Observer {
            mostExpensiveValue.text = it
        })

        val cheapestValue: TextView = root.findViewById(R.id.text_profile)
        statisticsViewModel.costOfCheapestValue.observe(viewLifecycleOwner, Observer {
            cheapestValue.text = it
        })
        return root
    }
}