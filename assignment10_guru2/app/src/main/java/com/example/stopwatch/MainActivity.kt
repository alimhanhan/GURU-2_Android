package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private var time = 0;
    private var timerTask: Timer? = null
    private var isRunning = false
    private var lap = 1

    lateinit var fab : FloatingActionButton
    lateinit var secTextView: TextView
    lateinit var milliTextview: TextView
    lateinit var LabLayout: LinearLayout
    lateinit var labButton: Button
    lateinit var resetFab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab = findViewById<FloatingActionButton>(R.id.fab)
        secTextView = findViewById<TextView>(R.id.secTextView)
        milliTextview = findViewById<TextView>(R.id.milliTextView)
        LabLayout = findViewById<LinearLayout>(R.id.labLayout)
        labButton =findViewById<Button>(R.id.button)
        resetFab = findViewById(R.id.resetFab)

        fab.setOnClickListener {
            isRunning = !isRunning
            if(isRunning)
            {
                start()
            } else {pause()}

            labButton.setOnClickListener {
                recordLapTime()
            }
            resetFab.setOnClickListener { reset() }

        }
    }

    private fun pause()
    {
        fab.setImageResource(R.drawable.ic_baseline_play_arrow_24)
        timerTask?.cancel()
    }

    private fun start(){
        fab.setImageResource(R.drawable.ic_baseline_pause_24)

        timerTask = timer(period=10){
            time++
            val sec = time / 100
            val milli = time % 100
            runOnUiThread { secTextView.text = "$sec"
            milliTextview.text =  "$milli"}
        }
    }

    private fun recordLapTime()
    {
        val lapTime = this.time
        val textView = TextView(this)
        textView.text = "$lap LAB : ${lapTime/100}.${lapTime%100}"

        LabLayout.addView(textView, 0)
        lap++
    }

    private fun reset()
    {
        timerTask?.cancel()
        time = 0
        isRunning = false
        fab.setImageResource(R.drawable.ic_baseline_play_arrow_24)
        secTextView.text = "0"
        milliTextview.text = "00"

        LabLayout.removeAllViews()
        lap = 1
    }
}