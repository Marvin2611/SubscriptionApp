package com.example.subscriptionapp.ui.sublistadd

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.style.UpdateLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.subscriptionapp.AboViewModel
import com.example.subscriptionapp.MainViewModel
import com.example.subscriptionapp.R
import java.lang.Error
import java.util.*


class SubListAddFragment : Fragment() {

    private lateinit var subListAddViewModel: SubListAddViewModel

    val model: MainViewModel by activityViewModels()
    var aboViewModelTemplate: AboViewModel = AboViewModel("")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        subListAddViewModel =
            ViewModelProviders.of(this).get(SubListAddViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sublistadd, container, false)

        val editTextName: EditText = root.findViewById(R.id.addlistelement_name)
        val editTextPeriod: EditText = root.findViewById(R.id.addlistelement_period)
        val editTextCost: EditText = root.findViewById(R.id.addlistelement_cost)
        val editTextColor: EditText = root.findViewById(R.id.addlistelement_color)

        val textName: TextView = root.findViewById(R.id.listelement_name)
        val textPeriod: TextView = root.findViewById(R.id.listelement_period)
        val textCost: TextView = root.findViewById(R.id.listelement_cost)
        val textColor: TextView = root.findViewById(R.id.listelement_color)

        editTextName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                UpdateTextBoxes(editTextName, textName)
            }
        })
        editTextPeriod.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                UpdateTextBoxes(editTextName, textName)
            }
        })
        editTextCost.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                UpdateTextBoxes(editTextName, textName)
            }
        })
        editTextColor.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                UpdateTextBoxes(editTextName, textName)
            }
        })

        val button = root.findViewById(R.id.addlistelement_button) as Button
        button.setOnClickListener{

            AddListItem(root.rootView, editTextName.text.toString(), editTextPeriod.text.toString(), editTextCost.text.toString(), editTextColor.text.toString())

            findNavController().navigate(R.id.action_navigation_sublistadd_to_navigation_sublist)
        }

        return root
    }

    fun UpdateTextBoxes(source: EditText, destination: TextView) {
        destination.text = source.text
    }

    fun AddListItem(v: View, name: String, period: String, cost: String, color: String) {
        //Checks if input is correct, else transformation will throw an error
        aboViewModelTemplate.name = name
        try {
            aboViewModelTemplate.abo_variant = period.toInt()
        }
        catch(error: Error) {
            Toast.makeText(activity?.applicationContext,"Error: " + error, Toast.LENGTH_SHORT).show()
        }

        try {
            aboViewModelTemplate.cost = cost.toDouble()
        }
        catch(error: Error) {
            Toast.makeText(activity?.applicationContext,"Error: " + error, Toast.LENGTH_SHORT).show()
        }
        aboViewModelTemplate.color = color

        model.list.add(aboViewModelTemplate)
    }
}