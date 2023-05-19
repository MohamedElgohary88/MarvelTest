package com.example.marveltest.ui.utils

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Fade
import androidx.transition.TransitionManager
import com.bumptech.glide.Glide
import com.example.marveltest.R
import com.example.marveltest.data.util.Status
import com.example.marveltest.ui.adapter.BaseAdapter

@BindingAdapter("imageUrl")
fun ImageView.loadImage(imageUrl: String?) {
    Glide.with(context)
        .load(imageUrl)
        .placeholder(R.drawable.ic_download)
        .error(R.drawable.ic_error)
        .into(this)
}

@BindingAdapter(value = ["app:items"])
fun <T> RecyclerView.setRecyclerItems(items: List<T>?) {
    (adapter as BaseAdapter<T>).setItems(items ?: emptyList())
}

@BindingAdapter(value = ["app:showWhenFailure"])
fun <T> View.showWhenFailure(status: Status<T>?) {
    val transition = Fade()
    TransitionManager.beginDelayedTransition(parent as ViewGroup, transition)
    visibility = if (status is Status.Failure) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> View.showWhenLoading(status: Status<T>?) {
    val transition = Fade()
    TransitionManager.beginDelayedTransition(parent as ViewGroup, transition)
    visibility = if (status is Status.Loading) {
        View.VISIBLE
    } else {
        View.GONE
    }
}