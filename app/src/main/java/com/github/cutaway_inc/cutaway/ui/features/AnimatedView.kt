package com.github.cutaway_inc.cutaway.ui.features

import android.view.View
import android.view.animation.Animation

import android.view.animation.ScaleAnimation

class AnimatedView(private val view: View) {
    fun setScaleAnimation() {
        val anim = ScaleAnimation(
            0.95f,
            1.0f,
            0.95f,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            0.95f,
            Animation.RELATIVE_TO_SELF,
            0.95f
        )
        anim.duration = Constants.FADE_DURATION
        view.startAnimation(anim)
    }
}

private object Constants {
    const val FADE_DURATION = 350L
}