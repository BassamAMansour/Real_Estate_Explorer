package org.sweng.realestateexplorer.ui.estatedetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import org.sweng.realestateexplorer.databinding.EstateDetailFragmentBinding


class EstateDetailFragment : Fragment() {

    private lateinit var binding: EstateDetailFragmentBinding
    private lateinit var viewModel: EstateDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EstateDetailFragmentBinding.inflate(inflater, container, false)

        binding.fabCallOwner.setOnClickListener {
            viewModel.user.value?.let {
                startActivity(Intent(Intent.ACTION_CALL, Uri.parse("tel:" + it.phone)))
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EstateDetailViewModel::class.java)
        viewModel.estate.value =
            EstateDetailFragmentArgs.fromBundle(arguments!!).estate

        viewModel.estate.observe(this, Observer {
            if (!::binding.isInitialized) return@Observer

            binding.switcherEstateImages.apply {
                removeAllViews()

                it.imgUrl.forEach { imgUrl ->
                    val iv = ImageView(this@EstateDetailFragment.requireContext())
                    Picasso.get().load(imgUrl).into(iv)
                    addView(iv)
                }
            }
        })
    }
}
