interface MailService {
    fun mailService()
}

class SendMail: MailService{
    override fun mailService() {
        println("Send Mail")
    }
}

class ReceiveMail: MailService{
    override fun mailService() {
        println("Receive Mail")
    }
}

interface OTPService {
    fun otpService()
}

class SendOTP: OTPService{
    override fun otpService() {
        println("Send OTP")
    }
}

class ResendOTP: OTPService{
    override fun otpService() {
        println("Resend OTP")
    }
}

interface Confirm{
    fun confirmInput()
}
abstract class Register: MailService, Confirm{
    abstract val userName: String
    abstract val userData: String

    abstract fun show()
}

class MessengerRegister : Register() {
    override val userName: String = "Name Messenger: Trung LQ"
    override val userData: String
        get() = userName + " Password: 0333982632"

    override fun show() {
        println(userData)
    }

    override fun mailService() {
        //val choose = SendMail()
        val choose = ReceiveMail()
        choose.mailService()
    }

    override fun confirmInput() {
        println("Confirmed Messenger with $userName")
    }
}

class FacebookRegister : Register(), OTPService {
    override val userName: String = "Name Facebook: Trung"
    override val userData: String
        get() = userName + " Password: lt1412003"

    override fun show() {
        println(userData)
    }

    override fun mailService() {
        val choose = SendMail()
        //val choose = ReceiveMail()
        choose.mailService()
    }

    override fun confirmInput() {
        println("Confirmed Facebook with $userName")
    }

    override fun otpService() {
        //val choose = SendOTP()
        val choose = ResendOTP()
        choose.otpService()
    }
}

fun main() {
    println("Messenger: ")
    val messengerRegister = MessengerRegister()
    messengerRegister.mailService()
    messengerRegister.confirmInput()
    messengerRegister.show()

    println("\nFacebook: ")
    val facebookRegister = FacebookRegister()
    facebookRegister.mailService()
    facebookRegister.otpService()
    facebookRegister.confirmInput()
    facebookRegister.show()

}



