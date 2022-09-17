package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(), Presenter.View {

    // Declare instance of Presenter
    private var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instantiate the presenter with the MainActivity (our view)
        presenter = Presenter(this)
    }

    // Changes the text in TextView with the string provided by the Presenter
    override fun updateCurrentExpression(string: String) {
        val tv: TextView = findViewById(R.id.currentExpression)
        tv.text = string
    }

    // Changes the text in TextView with the string provided by the Presenter
    override fun updateLastExpression(string: String) {
        val tv: TextView = findViewById(R.id.lastExpression)
        tv.text = string
    }

    // Listens for clicks on certain buttons and does whatever function it needs to
    fun buttonClicked(view: View){
        when(view.id) {
            (R.id.one) -> presenter?.addCharacter('1')
            (R.id.two) -> presenter?.addCharacter('2')
            (R.id.three) -> presenter?.addCharacter('3')
            (R.id.four) -> presenter?.addCharacter('4')
            (R.id.five) -> presenter?.addCharacter('5')
            (R.id.six) -> presenter?.addCharacter('6')
            (R.id.seven) -> presenter?.addCharacter('7')
            (R.id.eight) -> presenter?.addCharacter('8')
            (R.id.nine) -> presenter?.addCharacter('9')
            (R.id.zero) -> presenter?.addCharacter('0')
            (R.id.add) -> presenter?.addCharacter('+')
            (R.id.subtract) -> presenter?.addCharacter('-')
            (R.id.multiply) -> presenter?.addCharacter('*')
            (R.id.divide) -> presenter?.addCharacter('/')
            (R.id.decimal) -> presenter?.addCharacter('.')
            (R.id.clear) -> presenter?.clearExpressions()
            (R.id.back) -> presenter?.removeCharacter()
            (R.id.equals) -> presenter?.evaluate()
        }
    }
}