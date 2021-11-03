package com.github.cutaway_inc.cutaway.ui.features.anim

import android.view.View

class ViewAnimation {

    fun submitScaleAnim(view: View, force: Float) {
        val animator = AnimatedView(view)
        animator.setScaleAnimation(force)
    }
}