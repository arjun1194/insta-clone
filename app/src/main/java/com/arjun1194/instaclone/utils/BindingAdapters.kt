package com.arjun1194.instaclone.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:srcUrl")
fun bindImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view).load(it).into(view)
    }
}