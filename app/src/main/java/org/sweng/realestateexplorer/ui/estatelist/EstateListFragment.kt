package org.sweng.realestateexplorer.ui.estatelist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sweng.realestateexplorer.R

class EstateListFragment : Fragment() {

    companion object {
        fun newInstance() = EstateListFragment()
    }

    private lateinit var viewModel: EstateListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.estate_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EstateListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
