package com.shajib.mvppractice

/**
 * @author Shajib
 * @since Sept 17, 2024
 **/
class LoginModel : LoginContract.Model {
    private val users = arrayListOf<User>()

    override fun login(emailOrUsername: String, password: String): Boolean {
        return checkUser(emailOrUsername, password)
    }

    // Checking a valid user
    private fun checkUser(emailOrUsername: String, password: String): Boolean {
        users.add(User("john@abc.com", "john123", "password123"))
        users.add(User("mike@def.com", "mike789", "password789"))
        users.add(User("paul@xyz.com", "paul01", "paulxyz01"))
        users.add(User("jane@xyz.com", "jane456", "pass456"))
        users.add(User("abc", "abc", "abc"))

        for (user in users) {
            if ((user.username == emailOrUsername || user.email == emailOrUsername)
                && user.password == password
            ) return true
        }
        return false
    }
}