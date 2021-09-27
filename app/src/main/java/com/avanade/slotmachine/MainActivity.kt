package com.avanade.slotmachine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var button : Button
    private lateinit var imgSlot1 : ImageView
    private lateinit var imgSlot2 : ImageView
    private lateinit var imgSlot3 : ImageView
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.buttonSlot)
        imgSlot1 = findViewById(R.id.slot1)
        imgSlot2 = findViewById(R.id.slot2)
        imgSlot3 = findViewById(R.id.slot3)
        tvResult = findViewById(R.id.tvResult)

        val slotMachine : SlotMachine = SlotMachine()

        button.setOnClickListener {
            val slotResult = slotMachine.draw()
            imgSlot1.setImageDrawable(getDrawable(slotResult.first))
            imgSlot2.setImageDrawable(getDrawable(slotResult.second))
            imgSlot3.setImageDrawable(getDrawable(slotResult.third))
            tvResult.text = slotMachine.analyseResult(slotResult)
        }
    }
}