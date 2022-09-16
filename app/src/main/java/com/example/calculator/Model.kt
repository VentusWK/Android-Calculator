package com.example.calculator

import com.udojava.evalex.Expression

class Model {
    var currentExpression : String = ""
    var lastExpression : String = ""

    fun evaluate(){
        val expression = Expression(currentExpression)
        val result = expression.eval().toString()
        lastExpression = currentExpression
        currentExpression = result
    }
}