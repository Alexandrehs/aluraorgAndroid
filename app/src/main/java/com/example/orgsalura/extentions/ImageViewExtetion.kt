package com.example.orgsalura.extentions

import android.media.Image
import android.widget.ImageView
import coil.load
import com.example.orgsalura.R


fun ImageView.tentacarregarImagem(url : String? = null) {
    load(url) {
        fallback(R.drawable.placeholder)
        placeholder(R.drawable.placeholder)
    }
}