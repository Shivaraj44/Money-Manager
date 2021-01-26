package com.shivaraj.Moneymanager.Home

import android.view.animation.Interpolator


class MyBounceInterpolator(private val amplitude: Double, val frequency: Int) : Interpolator {
    private val mAmplitude = 1.0
    private val mFrequency = 10.0

    override fun getInterpolation(time: Float): Float {
        return (-1 * Math.pow(Math.E, -time / mAmplitude) *
                Math.cos(mFrequency * time) + 1).toFloat()
    }
}