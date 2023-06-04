data class User(val name: String, val mail: String)

interface MailService {
    fun sendOTP(mail: String)
}

class GmailService : MailService {
    override fun sendOTP(mail: String) {
        println("Connect to Gmail. Send OTP to $mail")
    }
}

class OutlookMailService : MailService {
    override fun sendOTP(mail: String) {
        println("Connect to Outlook. Send OTP to $mail")
    }
}

abstract class Register(private val mailService: MailService, private val domainServer: String) {
    abstract fun getDataFromUser(): User

    fun submit() {
        println("Connect to $domainServer")
        val user: User = getDataFromUser()
        mailService.sendOTP(user.mail)
        println("User ${user.mail} is registered!")
    }
}

class MessengerRegister(mailService: MailService, private val domainServer: String = "messenger.com") : Register(mailService, domainServer) {
    override fun getDataFromUser(): User {
        val mockData: List<User> = listOf(
            User("Nguyen Van A", "nguyenvana@gmail.com"),
            User("Nguyen Van B", "nguyenvanb@outlook.com"),
        )
        return mockData.random()
    }
}

fun main() {
    val gmailService = GmailService()
    val outlookMailService = OutlookMailService()

    val messReg = MessengerRegister(gmailService)
    messReg.submit()

    val anotherReg = MessengerRegister(outlookMailService)
    anotherReg.submit()
}