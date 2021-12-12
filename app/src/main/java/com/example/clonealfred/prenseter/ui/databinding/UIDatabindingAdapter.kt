package com.example.clonealfred.prenseter.ui.databinding

import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.text.toUpperCase
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.clonealfred.prenseter.ui.databinding.UIBindingAdapters.textUpperCase
import java.util.*

object UIBindingAdapters {

    @JvmStatic
    @BindingAdapter("updateImage")
    fun ImageView.updateImage(image: String) {
        Glide.with(this)
            .load(image)
            .into(this)
    }

    @JvmStatic
    @BindingAdapter("textUpperCase")
    fun TextView.textUpperCase(text: String) {
        this.text = text.uppercase(Locale.getDefault())
    }
}