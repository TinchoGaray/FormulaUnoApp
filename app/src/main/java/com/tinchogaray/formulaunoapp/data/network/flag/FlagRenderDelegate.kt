package com.tinchogaray.formulaunoapp.data.network.flag

import android.widget.ImageView
import com.squareup.picasso.Picasso

class FlagRenderDelegate {

    fun render(country: String, iv: ImageView) {
        Picasso.get().load(URL + country).into(iv)
    }

    companion object {
        const val URL = "https://countryflagsapi.com/png/"
    }
}
