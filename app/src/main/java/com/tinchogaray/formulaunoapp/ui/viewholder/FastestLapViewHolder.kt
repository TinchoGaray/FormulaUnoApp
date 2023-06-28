package com.tinchogaray.formulaunoapp.ui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.domain.model.FastestLapDriver

class FastestLapViewHolder(
    view: View
) : RecyclerView.ViewHolder(view)  {

    private val timeIcon: ImageView = view.findViewById<ImageView>(R.id.ivCharactIcon)
    private val fastestLapTime: TextView = view.findViewById<TextView>(R.id.tvTime)
    private val timeLineSeparator: ImageView = view.findViewById<ImageView>(R.id.ivLineSeparator)
    private val roundNumber: TextView = view.findViewById<TextView>(R.id.tvTotal)
    private val constructorIcon: ImageView = view.findViewById<ImageView>(R.id.ivScuderia)
    private val driverSeparator: ImageView = view.findViewById<ImageView>(R.id.ivDriverLineSeparator)
    private val driverName: TextView = view.findViewById<TextView>(R.id.tvDriver)

    fun render(item: FastestLapDriver) {
        driverName.text = item.name + " " + item.lastName
        fastestLapTime.text = item.time
        roundNumber.text = "Lap " + item.lap
    }
}
