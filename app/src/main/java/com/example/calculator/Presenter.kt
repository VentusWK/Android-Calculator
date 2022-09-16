package com.example.calculator

class Presenter(view: View){

    private var model = Model()
    private var view = this.view

    interface View{

    }
}