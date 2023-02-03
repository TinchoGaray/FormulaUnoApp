package com.tinchogaray.formulaunoapp.ui.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.domain.model.RaceSchedule

class ScheduleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val scheduleRaceImage: TextView = view.findViewById<TextView>(R.id.ivScheduleRace)
    val round: TextView = view.findViewById<TextView>(R.id.tvRound)
    val date: TextView = view.findViewById<TextView>(R.id.tvDate)
    val country: TextView = view.findViewById<TextView>(R.id.tvCountry)
    val circuitName: TextView = view.findViewById<TextView>(R.id.tvCircuitName)
    val raceName: TextView = view.findViewById<TextView>(R.id.tvRaceName)

    fun render(raceSchedule: RaceSchedule) {
        round.text = raceSchedule.round
        date.text = raceSchedule.date
        country.text = raceSchedule.circuit.location.country
        circuitName.text = raceSchedule.circuit.circuitName
        raceName.text = raceSchedule.raceName
    }
}