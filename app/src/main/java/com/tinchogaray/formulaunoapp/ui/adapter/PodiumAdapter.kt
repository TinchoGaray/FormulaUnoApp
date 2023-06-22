package com.tinchogaray.formulaunoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.domain.model.PodiumDriver
import com.tinchogaray.formulaunoapp.ui.viewholder.PodiumViewHolder

class PodiumAdapter(
    private val podiumDriverList: List<PodiumDriver>,
    private val clickListener: (PodiumDriver) -> Unit
) :  RecyclerView.Adapter<PodiumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodiumViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PodiumViewHolder(layoutInflater.inflate(R.layout.podium_item, parent, false)) {
            clickListener(podiumDriverList[it])
        }
    }

    override fun onBindViewHolder(holder: PodiumViewHolder, position: Int) {
        val item = podiumDriverList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = podiumDriverList.size
}
