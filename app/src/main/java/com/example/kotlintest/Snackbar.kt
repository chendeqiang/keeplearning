package com.example.kotlintest

import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 * Created by deqiangchen on 2024/10/19.
 */

fun View.showSnackbar(
    text: String,
    actionText: String? = null,
    duration: Int = Snackbar.LENGTH_SHORT,
    block: (() -> Unit)? = null
) {
    val snackbar = Snackbar.make(this, text, duration)
    if (actionText != null && block != null) {
        snackbar.setAction(actionText) {
            block()
        }
    }
    snackbar.show()
}

fun View.showSnackbar(
    resId: Int,
    actionResId: Int? = null,
    duration: Int = Snackbar.LENGTH_SHORT,
    block: (() -> Unit)? = null
) {
    val snackbar = Snackbar.make(this, resId, duration)
    if (actionResId!=null && block!=null){
        snackbar.setAction(actionResId){
            block()
        }
    }
    snackbar.show()
}