package com.example.subscriptionapp.ui.statistics

import android.os.Bundle
import android.text.style.UpdateLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.subscriptionapp.MainViewModel
import com.example.subscriptionapp.R
import kotlinx.android.synthetic.main.fragment_statistics.*

class StatisticsFragment : Fragment() {

    private lateinit var statisticsViewModel: StatisticsViewModel

    val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        statisticsViewModel = ViewModelProviders.of(this).get(StatisticsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_statistics, container, false)

        val costPerMonthValue: TextView = root.findViewById(R.id.costPerMonthValue)
        val costPerYearValue: TextView = root.findViewById(R.id.costPerYearValue)
        val highestValue: TextView = root.findViewById(R.id.mostExpensiveValue)
        val lowestValue: TextView = root.findViewById(R.id.cheapestValue)
        val averageValue: TextView = root.findViewById(R.id.averageValue)

        UpdateLayout(costPerMonthValue, costPerYearValue, highestValue, lowestValue, averageValue)

        return root
    }

    fun UpdateLayout(pmV: TextView, pyV: TextView, hV: TextView, lV: TextView, aV: TextView) {
        pmV.text = (model.stats.TotalSum*30).toString()+"€"
        pyV.text = (model.stats.TotalSum*365).toString()+"€"
        hV.text = (model.stats.highest*30).toString()+"€"
        lV.text= (model.stats.lowest*30).toString()+"€"
        aV.text = (model.stats.average*30).toString()+"€"
    }
}