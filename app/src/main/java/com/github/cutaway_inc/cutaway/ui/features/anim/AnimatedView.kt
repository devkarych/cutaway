package com.github.cutaway_inc.cutaway.ui.features.anim

import android.view.View
import android.view.animation.Animation

import android.view.animation.ScaleAnimation

class AnimatedView(private val view: View) {
    fun setScaleAnimation(force: Float) {
        val anim = ScaleAnimation(
            force,
            1.0f,
            force,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            force,
            Animation.RELATIVE_TO_SELF,
            force
        )
        anim.duration = Constants.FADE_DURATION
        view.startAnimation(anim)
    }
}

private object Constants {
    const val FADE_DURATION = 350L
}