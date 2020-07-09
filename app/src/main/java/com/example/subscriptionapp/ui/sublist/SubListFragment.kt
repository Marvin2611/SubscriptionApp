package com.example.subscriptionapp.ui.sublist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.subscriptionapp.AboViewModel
import com.example.subscriptionapp.MainViewModel
import com.example.subscriptionapp.R
import org.w3c.dom.Text


class SubListFragment : Fragment() {

    private lateinit var subListViewModel: SubListViewModel

    val model: MainViewModel by activityViewModels()

    var aboName: ArrayList<String> = ArrayList()

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

        val listView: ListView = root.findViewById(R.id.sublist_view)

        val adapter:ArrayAdapter<AboViewModel> = ArrayAdapter(root.context,android.R.layout.simple_list_item_1,model.list)
        listView.adapter = adapter

        return root
    }
}

