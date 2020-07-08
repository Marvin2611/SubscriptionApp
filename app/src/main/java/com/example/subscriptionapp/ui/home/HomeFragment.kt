package com.example.subscriptionapp.ui.home

import android.graphics.Color
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
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    val model: MainViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val activeSubscriptionValue: TextView = root.findViewById(R.id.active_subscriptions_value)
        activeSubscriptionValue.text = "5"

        val totalCostPerMonthValue: TextView = root.findViewById(R.id.total_cost_value)
        totalCostPerMonthValue.text = "55€"

        val averageCostPerSubPerMonthValue: TextView = root.findViewById(R.id.average_cost_value)
        averageCostPerSubPerMonthValue.text = "11€"

        //Add the PieChart here as a value
        val pieChart: PieChart = root.findViewById(R.id.pieChart);
        setPieChartData(view = root.rootView)

        val sub: TextView = root.findViewById(R.id.active_subscriptions_value)
        UpdateLayout(sub)

        return root
    }

    //Set the PieChart Data
    fun setPieChartData(view: View) {
        val listPie = ArrayList<PieEntry>()
        val listColors = ArrayList<Int>()

        //Add PieChart Data here
        listPie.add(PieEntry(20F, "Pass"))
        listPie.add(PieEntry(50F, "Fail"))
        listPie.add(PieEntry(30F, "Unanswered"))
        listColors.add(resources.getColor(R.color.colorPrimary))

        //Connect colors to the PieChart
        val pieDataSet = PieDataSet(listPie, "")
        pieDataSet.colors = listColors

        //Connect data to the PieChart
        val pieData = PieData(pieDataSet)
        view.pieChart.data = pieData

        view.pieChart.setUsePercentValues(true)
        view.pieChart.isDrawHoleEnabled = true
        view.pieChart.description.isEnabled = false
        view.pieChart.centerText = "test"
    }

    fun UpdateLayout(item: TextView){
        item.text = model.list.count().toString()
    }
}