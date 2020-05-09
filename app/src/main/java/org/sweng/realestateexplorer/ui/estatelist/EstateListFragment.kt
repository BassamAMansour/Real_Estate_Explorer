package org.sweng.realestateexplorer.ui.estatelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import org.sweng.realestateexplorer.R
import org.sweng.realestateexplorer.data.estates.EstateRepository
import org.sweng.realestateexplorer.databinding.EstateListFragmentBinding

class EstateListFragment : Fragment() {

    private lateinit var binding: EstateListFragmentBinding
    private lateinit var viewModel: EstateListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.estate_list_fragment,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, EstateListViewModelFactory(EstateRepository()))
            .get(EstateListViewModel::class.java)

        viewModel.estates.observe(this, Observer {
            Log.i(this::class.java.simpleName, it.toString())
            binding.rvEstates.adapter = EstateAdapter(it, requireContext())
        })
    }
}
