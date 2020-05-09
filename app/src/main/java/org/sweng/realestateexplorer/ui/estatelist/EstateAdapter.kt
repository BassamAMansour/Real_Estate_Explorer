package org.sweng.realestateexplorer.ui.estatelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*
import org.sweng.realestateexplorer.R
import org.sweng.realestateexplorer.data.estates.Estate

class EstateAdapter(val it: List<Estate>, val context: Context) : RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false))
    }

    override fun getItemCount(): Int {
        var ind = 0
        if (!it.isEmpty()){
         ind = it.size
        }
        return ind
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setData(this.it[position])
    }

}


class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(estate: Estate){
        itemView.list_item_address.text = estate.address.toString()
        itemView.list_item_price.text = estate.price.toString()
        itemView.list_item_type.text =estate.creationTime.toString()
        Picasso.get().load(estate.imgUrl[0]).into( itemView.list_item_image)
    }


    }