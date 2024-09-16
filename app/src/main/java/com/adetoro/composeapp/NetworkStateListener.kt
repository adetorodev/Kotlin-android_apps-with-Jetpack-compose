package com.adetoro.composeapp

import android.content.Context
import androidx.lifecycle.LifecycleOwner

interface NetworkStateListener {
    fun oberserveNetworkState(context: Context,
                              lifecyleOwner: LifecycleOwner)
}