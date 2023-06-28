package com.tinchogaray.formulaunoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.domain.model.FastestLapDriver
import com.tinchogaray.formulaunoapp.ui.viewholder.FastestLapViewHolder

class FastestLapAdapter(
    private val fastestLapDriverList: List<FastestLapDriver>
) : RecyclerView.Adapter<FastestLapViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FastestLapViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FastestLapViewHolder(layoutInflater.inflate(R.layout.podium_item, parent, false))
    }

    override fun onBindViewHolder(holder: FastestLapViewHolder, position: Int) {
        val item = fastestLapDriverList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = fastestLapDriverList.size
}
