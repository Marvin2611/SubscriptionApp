package com.example.subscriptionapp.ui.sublistadd

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.subscriptionapp.AboViewModel
import com.example.subscriptionapp.MainViewModel
import com.example.subscriptionapp.R
import java.util.*


class SubListAddFragment : Fragment() {

    private lateinit var subListAddViewModel: SubListAddViewModel

    val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        subListAddViewModel =
            ViewModelProviders.of(this).get(SubListAddViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sublistadd, container, false)


        val button = root.findViewById(R.id.addlistelement_button) as Button
        button.setOnClickListener{

            AddListItem()

            findNavController().navigate(R.id.action_navigation_sublistadd_to_navigation_sublist)
        }

        return root
    }

    fun AddListItem() {
        model.list.add(AboViewModel("Netflix", 30,15.99, Calendar.getInstance().getTime(),1,"#053225"))
    }
}