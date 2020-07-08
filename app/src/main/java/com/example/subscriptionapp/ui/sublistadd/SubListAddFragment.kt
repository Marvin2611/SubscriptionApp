package com.example.subscriptionapp.ui.sublistadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.subscriptionapp.R
import com.example.subscriptionapp.ui.sublist.SubListViewModel

class SubListAddFragment : Fragment() {

    private lateinit var subListAddViewModel: SubListAddViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subListAddViewModel =
            ViewModelProviders.of(this).get(SubListAddViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sublistadd, container, false)

        return root
    }
}