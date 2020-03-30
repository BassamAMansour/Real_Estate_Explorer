package org.sweng.realestateexplorer.ui.estatelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import org.sweng.realestateexplorer.R
import org.sweng.realestateexplorer.databinding.EstateListFragmentBinding

class EstateListFragment : Fragment() {

    private lateinit var viewModel: EstateListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<EstateListFragmentBinding>(
            inflater,
            R.layout.estate_list_fragment,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EstateListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
