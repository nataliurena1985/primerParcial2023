package com.example.magazies.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.magazies.R

class MagaziesDetailsFragments : Fragment() {

    companion object {
        fun newInstance() = MagaziesDetailsFragments()
    }

    private lateinit var viewModel: MagaziesDetailsFragmentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_magazies_details_fragments, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MagaziesDetailsFragmentsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}