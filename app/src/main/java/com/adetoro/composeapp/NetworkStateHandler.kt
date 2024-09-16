package com.adetoro.composeapp

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner

class NetworkStateHandler: NetworkStateListener {
//    override fun observeNetworkState(context: Context,
//                                     lifecycleOwner: LifecycleOwner){
//        Log.v("TAGY", "Observing the Network State")
//    }

    override fun oberserveNetworkState(context: Context, lifecyleOwner: LifecycleOwner) {
        Log.v("TAGY", "Observing the Network State")
    }
}