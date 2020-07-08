package com.example.subscriptionapp.ui.profile

import android.os.Bundle
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

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    val model: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProviders.of(this).get(ProfileViewModel::class.java) //?
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        return root
    }
}