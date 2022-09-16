package com.example.calculator

import android.view.Display.Mode
import org.junit.Assert.*
import org.junit.Test

class CalcModelUnitTest {
    lateinit var model:Model
    @Test
    fun test1(){
        model = Model()
        model.currentExpression = "9+4"
        model.evaluate()
        assertEquals(model.currentExpression, "13")
    }
}