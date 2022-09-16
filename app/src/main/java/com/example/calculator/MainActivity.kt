package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(), Presenter.View {
    private var presenter: Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declare and instantiate the presenter with the MainActivity (our view)
        presenter = Presenter(this)
    }
    // Button declarations
    var button1 = findViewById<Button>(R.id.one)
    var button2 = findViewById<Button>(R.id.two)
    var button3 = findViewById<Button>(R.id.three)
    var button4 = findViewById<Button>(R.id.four)
    var button5 = findViewById<Button>(R.id.five)
    var button6 = findViewById<Button>(R.id.six)
    var button7 = findViewById<Button>(R.id.seven)
    var button8 = findViewById<Button>(R.id.eight)
    var button9 = findViewById<Button>(R.id.nine)

    // Listen for clicks

}