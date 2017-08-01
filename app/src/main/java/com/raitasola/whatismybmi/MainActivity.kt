package com.raitasola.whatismybmi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var heightSlider: SeekBar
    lateinit var heightText: TextView
    lateinit var weightSlider: SeekBar
    lateinit var weightText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heightSlider = findViewById(R.id.heightSlider) as SeekBar
        heightText = findViewById(R.id.heightText) as TextView
        weightSlider = findViewById(R.id.weightSlider) as SeekBar
        weightText = findViewById(R.id.weightText) as TextView

        heightSlider.max = 240
        heightSlider.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                heightText.text = progress.toString()
            }
        })

        weightSlider.max = 200
        weightSlider.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                weightText.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
}
