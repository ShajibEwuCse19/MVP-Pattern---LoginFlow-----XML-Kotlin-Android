package com.shajib.mvppractice

/**
 * @author Shajib
 * @since Sept 17, 2024
 **/


//Presenter: Middle man between View and Model

// Presenter takes the view and model as parameter
// and taking input (emailOrUsername, password) from view and passing it to model for login
// and again passing the result to view

//summary: view (emailOrUsername, password) -> presenter -> model (login validation) -> presenter -> view (result)
class LoginPresenter(
    private val mainView: LoginContract.View,
    private val model: LoginContract.Model = LoginModel()
) : LoginContract.Presenter {
    override fun onLoginButtonClick(emailOrUsername: String, password: String) {
        if(model.login(emailOrUsername, password)) {
            mainView.showLoginSuccessMessage()
        } else {
            mainView.showInvalidCredentialsError()
        }
    }
}

// View: taking input (emailOrUsername, password) from user and passing it to PRESENTER
// PRESENTER: taking input (emailOrUsername, password) from VIEW based on button click or text change and passing it to MODEL for login
// MODEL: checking a valid user and passing the result to PRESENTER
// Presenter: passing the result to VIEW (success or failure)
// VIEW: displaying the result to user

// VIEW --><-- PRESENTER --><-- MODEL

//Contract: interface for the View, Presenter, Model