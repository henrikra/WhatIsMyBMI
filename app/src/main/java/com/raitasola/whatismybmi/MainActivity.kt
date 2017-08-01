package com.raitasola.whatismybmi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var heightSlider: SeekBar
    lateinit var heightText: TextView
    lateinit var weightSlider: SeekBar
    lateinit var weightText: TextView
    lateinit var bmiResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightSlider = findViewById(R.id.heightSlider) as SeekBar
        heightText = findViewById(R.id.heightText) as TextView
        weightSlider = findViewById(R.id.weightSlider) as SeekBar
        weightText = findViewById(R.id.weightText) as TextView
        bmiResult = findViewById(R.id.bmiResult) as TextView

        heightSlider.max = 240
        heightSlider.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                heightText.text = progress.toString()
                updateBMI()
            }
        })

        weightSlider.max = 200
        weightSlider.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                weightText.text = progress.toString()
                updateBMI()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    private fun updateBMI() {
        val heightInMeters: Double = heightSlider.progress.toDouble() / 100
        val weightInKilos: Int = weightSlider.progress
        val bmi: Double = weightInKilos / Math.pow(heightInMeters, 2.0)
        bmiResult.text = "%.1f".format(bmi)
    }
}
