package com.example.subscriptionapp.ui.sublist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.subscriptionapp.R
import kotlinx.android.synthetic.main.activity_main.*


class SubListFragment : Fragment() {

    private lateinit var subListViewModel: SubListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subListViewModel =
            ViewModelProviders.of(this).get(SubListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sublist, container, false)

        return root
    }
}