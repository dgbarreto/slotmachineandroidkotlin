package com.avanade.slotmachine

import kotlin.random.Random

public class SlotMachine {
    private var slotImages = mutableListOf<Int>(R.drawable.banana, R.drawable.bar,  R.drawable.cherry, R.drawable.diamond, R.drawable.dolar, R.drawable.grape, R.drawable.lemon, R.drawable.seven)

    fun drawSlot() : Int{
        val output : Int = (0..(slotImages.size - 1)).random()
        return slotImages[output]
    }

    fun draw() : Triple<Int, Int, Int>{
        val slot1 : Int = drawSlot()
        val slot2 : Int = drawSlot()
        val slot3 : Int = drawSlot()
        var output : Triple<Int, Int, Int> = Triple(slot1, slot2, slot3)

        return output
    }

    fun analyseResult(result: Triple<Int, Int, Int>) : String{
        if(result.first == result.second && result.first == result.third){
            return "Jackpot!!!"
        }

        if(result.first == result.second || result.first == result.third || result.second == result.third){
            return "Legal! Ganhou R$100!"
        }

        return "Continue tentando"
    }
}