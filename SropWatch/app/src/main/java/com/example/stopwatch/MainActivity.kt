package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import kotlin.concurrent.timer


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekbar : SeekBar = findViewById(R.id.seekerBar)
        val time : TextView = findViewById(R.id.time)
        val start : Button = findViewById (R.id.start)
        val stop : Button = findViewById(R.id.stop)
        var timeTick = 0
        var minute = 0
        var second = 0
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener
        {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                timeTick = progress
                time.text = String.format("%02d : %02d", timeTick/60, timeTick%60)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                timeTick = seekBar!!.progress
                time.text = String.format("%02d : %02d", timeTick/60, timeTick%60)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                timeTick = seekBar!!.progress
                time.text = String.format("%02d : %02d", timeTick/60, timeTick%60)
            }
        })
        start.setOnClickListener()
        {
            minute = timeTick/60
            second = timeTick % 60

            timer(period = 1000, initialDelay = 1000)
            {
                runOnUiThread { time.text = String.format("%02d : %02d", minute, second) }
                if(second==0&&minute==0)
                {
                    println("\n종료")
                    cancel()
                }
                if(second==0)
                {
                    minute--
                    stop.setOnClickListener()
                    {
                        cancel()
                    }
                }
            }
        }
    }
}