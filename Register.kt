package com.example.test

data class User(val name: String, val email: String, val phoneNumber: String)

//val users = mutableListOf<User>()

interface Confirm {
    fun sendOTP(data: User)
}

class MailService : Confirm {
    override fun sendOTP(data: User) {
        println("Thank you ${data.name} for subscribing to our service")
        println("We sent OTP code to ${data.email}, please check your email!")
    }
}

class PhoneNumberService : Confirm {
    override fun sendOTP(data: User) {
        println("Thank you ${data.name} for subscribing to our service")
        println("We sent OTP code to ${data.phoneNumber}, please check your phone!")
    }
}

abstract class Register {
    abstract val confirm: Confirm
    abstract fun getDataFromUser(): User

    fun submit() {
        val data = getDataFromUser()
        confirm.sendOTP(data)
    }
}

class FacebookRegister(override val confirm: Confirm) : Register() {
    override fun getDataFromUser(): User {
        print("Enter your name: ")
        val name: String = readln()
        print("Enter your email: ")
        val mail: String = readln()
        print("Enter your phone: ")
        val phone: String = readln()

        //        users.add(user)
        return User(name, mail, phone)
    }
}

fun main() {
    val register: Register

    println("Register by:")
    println("1. Email")
    println("2. Phone number")
    println("3. Exit")
    print("Enter choice: ")

    when (readln().toInt()) {
        1 -> {
            register = FacebookRegister(MailService())
            register.submit()
        }

        2 -> {
            register = FacebookRegister(PhoneNumberService())
            register.submit()
        }

        else -> println("Invalid")
    }
}