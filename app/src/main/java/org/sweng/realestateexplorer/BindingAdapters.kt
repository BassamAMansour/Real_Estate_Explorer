package org.sweng.realestateexplorer

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("date")
fun date(tv: TextView, date: Date) {
    tv.text = SimpleDateFormat("MM/dd/YYYY").format(date)
}