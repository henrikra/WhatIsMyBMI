package com.raitasola.whatismybmi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightSlider.max = 240
        heightSlider.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                heightText.text = "$progress cm"
                updateBMI()
            }
        })

        weightSlider.max = 200
        weightSlider.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                weightText.text = "$progress kg"
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
