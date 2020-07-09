package com.example.subscriptionapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel

class SublistAdapter(private val context: Activity, private val aboData: MainViewModel)
    : ArrayAdapter<String>(context, R.layout.sublist_item) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.sublist_item, null, true)

        val nameText: TextView = rowView.findViewById(R.id.list_item_name)
        val costText: TextView = rowView.findViewById(R.id.list_item_cost)

        nameText.text = aboData.list[position].name
        costText.text = aboData.list[position].cost.toString()

        return rowView
    }
}