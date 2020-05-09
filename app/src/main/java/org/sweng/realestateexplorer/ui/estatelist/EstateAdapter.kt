package org.sweng.realestateexplorer.ui.estatelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*
import org.sweng.realestateexplorer.R
import org.sweng.realestateexplorer.data.estates.Estate
import org.sweng.realestateexplorer.date

class EstateAdapter(val estates: List<Estate>, val context: Context) :
    RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount() = estates.count()

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setData(this.estates[position])
    }
}


class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(estate: Estate) {
        itemView.list_item_address.text = estate.address.address
        itemView.list_item_price.text = estate.price
        itemView.tv_city.text = estate.address.city
        date(itemView.list_item_type, estate.creationTime.toDate())
        Picasso.get().load(estate.imgUrl[0]).into(itemView.list_item_image)
        itemView.setOnClickListener {
            itemView.findNavController().navigate(
                EstateListFragmentDirections.actionEstateListFragmentToEstateDetailFragment(estate)
            )
        }
    }
}