package com.tinchogaray.formulaunoapp.data.network.youtube

import android.content.Intent
import android.net.Uri

class RaceHighlightsDelegate {

    private val BASE_URL = "https://www.youtube.com/results?search_query=highlights+"

    fun openYoutube(raceName: String, year: String): Intent {
        val intent = Intent(Intent.ACTION_VIEW, getFormatUrl(raceName, year))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.google.android.youtube")

        return intent
    }

    private fun getFormatUrl(raceName: String, year: String): Uri {
        val url = BASE_URL + raceName + " " + year
        return Uri.parse(url)
    }
}
