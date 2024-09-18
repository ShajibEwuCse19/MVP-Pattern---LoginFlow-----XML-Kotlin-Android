package com.shajib.mvppractice

/**
 * @author Shajib
 * @since Sept 17, 2024
 **/
interface LoginContract {
    // interface for the View
    interface View {
        fun showInvalidCredentialsError()
        fun showLoginSuccessMessage()
    }

    // interface for the Presenter
    interface Presenter {
        fun onLoginButtonClick(emailOrUsername: String, password: String)
    }

    // interface for the Model
    interface Model {
        fun login(emailOrUsername: String, password: String): Boolean
    }
}