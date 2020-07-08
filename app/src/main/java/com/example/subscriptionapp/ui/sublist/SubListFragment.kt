package com.example.subscriptionapp.ui.sublist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.subscriptionapp.R
import com.example.subscriptionapp.ui.sublistadd.SubListAddFragment
import kotlinx.android.synthetic.main.fragment_sublist.*
import org.json.JSONObject
import java.io.File


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

        val button = root.findViewById(R.id.navigation_sublistadd_button) as Button
        button.setOnClickListener{
            //Toast.makeText(activity?.applicationContext,"You Clicked me", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_navigation_sublist_to_navigation_sublistadd)
        }
        return root
    }
}

