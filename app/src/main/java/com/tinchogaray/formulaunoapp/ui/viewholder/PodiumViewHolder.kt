package com.tinchogaray.formulaunoapp.ui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.domain.model.PodiumDriver
import com.tinchogaray.formulaunoapp.ui.util.delegate.ConstructorRenderDelegate
import com.tinchogaray.formulaunoapp.ui.util.delegate.IconColorRenderDelegate

class PodiumViewHolder(
    view: View,
    clickListener: (Int) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val positionIcon: ImageView = view.findViewById<ImageView>(R.id.ivCharactIcon)
    private val totalTime: TextView = view.findViewById<TextView>(R.id.tvTime)
    private val timeLineSeparator: ImageView = view.findViewById<ImageView>(R.id.ivLineSeparator)
    private val totalPoints: TextView = view.findViewById<TextView>(R.id.tvTotal)
    private val constructorIcon: ImageView = view.findViewById<ImageView>(R.id.ivScuderia)
    private val driverSeparator: ImageView = view.findViewById<ImageView>(R.id.ivDriverLineSeparator)
    private val driverName: TextView = view.findViewById<TextView>(R.id.tvDriver)

    fun render(podiumDriver: PodiumDriver) {
        driverName.text = podiumDriver.name + " " + podiumDriver.lastName
        totalPoints.text = podiumDriver.points + "pts"
        totalTime.text = podiumDriver.time
        renderConstructorImage(podiumDriver.constructorId)
        renderIconColors(podiumDriver.constructorId)
    }

    fun renderConstructorImage(constructorId: String) {
        ConstructorRenderDelegate().render(constructorId)
    }

    fun renderIconColors(constructorId: String) {
        IconColorRenderDelegate().render(constructorId)
    }
}
