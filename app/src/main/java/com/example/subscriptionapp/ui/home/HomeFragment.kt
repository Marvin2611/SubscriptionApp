package com.example.subscriptionapp.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.subscriptionapp.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    val pieChart: PieChart = TODO()
    val pieData: PieData = PieData()
    val pieDataSet: PieDataSet = TODO()
    var pieEntries: ArrayList<PieEntry>
    val pieEntryLabels: ArrayList<PieEntry>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root

        pieDataSet = PieDataSet(pieEntries, "")
        pieData = PieData(pieDataSet)
        pieChart.setData(pieData)
        pieDataSet.setSliceSpace(2f)
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);
    }

    fun getEntries() {
        val pieEntries: ArrayList<PieEntry> = ArrayList()
        pieEntries.add(PieEntry(2f, 1))
        pieEntries.add(PieEntry(4f, 1))
        pieEntries.add(PieEntry(6f, 2))
        pieEntries.add(PieEntry(8f, 3))
        pieEntries.add(PieEntry(7f, 4))
        pieEntries.add(PieEntry(3f, 5))
    }
}