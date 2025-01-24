package com.shackleton.shape.shared

import android.app.Application
import com.shackleton.shape.shared.preferences.Preferences

class SharedApp: Application() {
    companion object {
        /**
         * SharedPreference manager
         */
        lateinit var preferences: Preferences

    }

    override fun onCreate() {
        super.onCreate()
        preferences = Preferences(applicationContext)
    }
}