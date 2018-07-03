package com.example.hallefy.filmskotlin.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadUrl(url: String) {
    Picasso.with(context).load(url).into(this)
}

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.isVisible() : Boolean {
    return this.visibility == View.VISIBLE
}