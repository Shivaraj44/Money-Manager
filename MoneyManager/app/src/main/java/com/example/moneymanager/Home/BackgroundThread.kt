package com.shivaraj.Moneymanager.Home

import android.os.Handler
import android.os.HandlerThread

class BackgroundThread(name: String?, looperPreparedListener: LooperPreparedListener) :
    HandlerThread(name) {
    private val looperPreparedListener: LooperPreparedListener
    private var mHandler: Handler? = null
    override fun onLooperPrepared() {
        super.onLooperPrepared()
        mHandler = Handler(looper)
        looperPreparedListener.looperpreparedListner()
    }

    fun addTaskToMessageQueue(task: Runnable?) {
        mHandler!!.post(task!!)
    }

    init {
        this.looperPreparedListener = looperPreparedListener
    }
}