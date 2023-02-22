package com.tinchogaray.formulaunoapp.ui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tinchogaray.formulaunoapp.R
import com.tinchogaray.formulaunoapp.domain.model.RaceSchedule

class ScheduleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val scheduleRaceImage: ImageView = view.findViewById<ImageView>(R.id.ivScheduleRace)
    val round: TextView = view.findViewById<TextView>(R.id.tvRound)
    val date: TextView = view.findViewById<TextView>(R.id.tvDate)
    val country: TextView = view.findViewById<TextView>(R.id.tvCountry)
    val circuitName: TextView = view.findViewById<TextView>(R.id.tvCircuitName)
    val raceName: TextView = view.findViewById<TextView>(R.id.tvRaceName)
    val countryImage: ImageView = view.findViewById<ImageView>(R.id.ivCountry)

    fun render(raceSchedule: RaceSchedule) {
        round.text = "Round " + raceSchedule.round
        date.text = raceSchedule.date
        country.text = raceSchedule.circuit.location.country
        circuitName.text = raceSchedule.circuit.circuitName
        raceName.text = raceSchedule.raceName
        renderRaceImage(raceSchedule.raceName)
    }

    private fun renderRaceImage(raceName: String) {
        when (raceName) {
            "Bahrain Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.bahrain_grand_prix)
            }
            "Saudi Arabian Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.saudi_arabian_grand_prix)
            }
            "Australian Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.australian_grand_prix)
            }
            "Emilia Romagna Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.emilia_romagna_grand_prix)
            }
            "Miami Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.miami_grand_prix)
            }
            "Spanish Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.spanish_grand_prix)
            }
            "Monaco Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.monaco_grand_prix)
            }
            "Azerbaijan Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.azerbaijan_grand_prix)
            }
            "Canadian Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.canadian_grand_prix)
            }
            "British Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.british_grand_prix)
            }
            "Austrian Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.austrian_grand_prix)
            }
            "French Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.french_grand_prix)
            }
            "Hungarian Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.hungarian_grand_prix)
            }
            "Belgian Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.belgian_grand_prix)
            }
            "Dutch Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.dutch_grand_prix)
            }
            "Italian Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.italian_grand_prix)
            }
            "Singapore Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.singapore_grand_prix)
            }
            "Japanese Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.japanese_grand_prix)
            }
            "United States Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.united_states_grand_prix)
            }
            "Mexico City Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.mexico_city_grand_prix)
            }
            "Brazilian Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.brazilian_grand_prix)
            }
            "Abu Dhabi Grand Prix" -> {
                scheduleRaceImage.setImageResource(R.drawable.abu_dhabi_grand_prix)
            }
            else -> {
                scheduleRaceImage.setImageResource(R.drawable.error_404)
            }
        }
    }
}