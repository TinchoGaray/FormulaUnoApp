package com.tinchogaray.formulaunoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.domain.model.RaceSchedule
import com.tinchogaray.formulaunoapp.ui.viewholder.ScheduleViewHolder

class ScheduleAdapter(
    private var scheduleRaceList: List<RaceSchedule>,
    private val highlightsClickListener: (RaceSchedule) -> Unit,
    private val resultClickListener: (RaceSchedule) -> Unit,
) : RecyclerView.Adapter<ScheduleViewHolder>() {

    private lateinit var highlightsListener: OnHighlightsClickListener

    //TODO cambiar la llamada a los on click listener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ScheduleViewHolder(layoutInflater.inflate(R.layout.schedule_race_item, parent, false),
            ({
                highlightsClickListener(scheduleRaceList[it])
            })
        ) {
            resultClickListener(scheduleRaceList[it])
        }
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val item = scheduleRaceList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = scheduleRaceList.size
}

interface OnHighlightsClickListener {

    fun highlightsClick(raceName: String, year: String)

}
