package com.example.musicserviceapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MusicService : Service() {
    lateinit var mp: MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("서비스 테스트", "onStartCommand()")

        mp=MediaPlayer.create(this, R.raw.guru2)
        mp.isLooping=true
        mp.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {


        Log.i("서비스 테스트", "onCreate()")

        super.onCreate()
    }

    override fun onDestroy() {
        Log.i("서비스 테스트", "onDestroy()")
        mp.stop()
        super.onDestroy()
    }
}