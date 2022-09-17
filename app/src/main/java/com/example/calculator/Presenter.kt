package com.example.calculator

import com.udojava.evalex.Expression
import com.udojava.evalex.Expression.ExpressionException

class Presenter(v: View){

    // Instantiate model and view within presenter
    private var model = Model()
    private var view = v

    // This method is called by presenter when any button but CLR is hit.
    // Takes a character and adds it to the current expression in the model.
    fun addCharacter(c : Char){
        model.currentExpression += c
        updateView(view, model)
    }

    // Called when BACK is used in the view
    // Removes a character from the current expression
    fun removeCharacter(){
        model.currentExpression = model.currentExpression.dropLast(1)
        updateView(view, model)
    }

    // Use EvalEx library to evaluate expression and save it to the current expression.
    // Moves current expression to the last expression and the result stays in current.
    fun evaluate(){
        val expression = Expression(model.currentExpression)
        try{
            val result = expression.eval().toPlainString()
            model.lastExpression = model.currentExpression
            model.currentExpression = result
        }
        // If you divide by zero or do weird stuff like "12**2", you'll end up here.
        catch (e: Exception){
            when(e){
                is ExpressionException -> clearExpressions()
                is java.lang.ArithmeticException -> {
                    clearExpressions()
                    model.lastExpression = "Divide by 0 Error"
                }
            }
        }
        updateView(view, model)
    }

    // Called whenever a numeral or an operator is pressed.
    private fun updateView(view: View, model: Model){
        view.updateCurrentExpression(model.currentExpression)
        view.updateLastExpression(model.lastExpression)
    }

    // Called when CLR is hit in the view
    // Empties every string in everything
    fun clearExpressions(){
        view.updateLastExpression("")
        view.updateCurrentExpression("")
        model.lastExpression = ""
        model.currentExpression = ""
    }

    // View is an interface so MainActivity can inherit from it (making it our View effectively)
    interface View{
        fun updateCurrentExpression(string: String)
        fun updateLastExpression(string: String)
    }
}