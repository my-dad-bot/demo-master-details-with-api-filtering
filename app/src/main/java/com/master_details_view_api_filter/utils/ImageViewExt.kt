package com.master_details_view_api_filter.utils

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.imageview.ShapeableImageView
import com.master_details_view_api_filter.R


fun ImageView.load(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .error(R.drawable.ic_baseline_broken_image)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .placeholder(R.drawable.ic_baseline_broken_image)
        .into(this)
}

fun ShapeableImageView.load(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .error(R.drawable.ic_baseline_broken_image)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .placeholder(R.drawable.ic_baseline_broken_image)
        .into(this)
}

fun ImageView.load(id: Int) {
    Glide.with(this)
        .asDrawable()
        .load(id)
        .centerCrop()
        .error(R.drawable.ic_baseline_broken_image)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .placeholder(R.drawable.ic_baseline_broken_image)
        .into(this)
}

fun ImageView.load(bitmap: Bitmap) {
    Glide.with(this)
        .asBitmap()
        .load(bitmap)
        .centerCrop()
        .error(R.drawable.ic_baseline_broken_image)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .placeholder(R.drawable.ic_baseline_broken_image)
        .into(this)
}

fun ImageView.loadCircular(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .circleCrop()
        .error(R.drawable.ic_baseline_broken_image)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .placeholder(R.drawable.ic_baseline_broken_image)
        .into(this)
}

fun ImageView.loadCircular(bitmap: Bitmap) {
    Glide.with(this)
        .asBitmap()
        .load(bitmap)
        .centerCrop()
        .circleCrop()
        .error(R.drawable.ic_baseline_broken_image)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .placeholder(R.drawable.ic_baseline_broken_image)
        .into(this)
}

fun ImageView.loadCircular(id: Int) {
    Glide.with(this)
        .asDrawable()
        .load(id)
        .centerCrop()
        .circleCrop()
        .error(R.drawable.ic_baseline_broken_image)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .placeholder(R.drawable.ic_baseline_broken_image)
        .into(this)
}