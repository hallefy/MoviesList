package com.example.hallefy.filmskotlin.views.movielist.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by hallefy on 18/08/17.
 */
fun ImageView.loadUrl(url: String) {
    Picasso.with(context).load(url).into(this)
}
