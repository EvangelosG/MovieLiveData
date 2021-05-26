package com.raywenderlich.android.movieapp.connectivity

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import androidx.lifecycle.LiveData

class ConnectivityLiveData(private val connectivityManager: ConnectivityManager) :
    LiveData<Boolean>() {

    constructor(application: Application) : this(
        application.getSystemService(
            Context
                .CONNECTIVITY_SERVICE
        )
                as ConnectivityManager
    )

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            //4
            postValue(true)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            //5
            postValue(false)
        }
    }
}