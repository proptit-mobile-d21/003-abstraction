data class Person(val name: String, val mail: String)

interface IMailService {
    fun sendMail(person: Person, message: String)
}

class SendGridMailService : IMailService {
    override fun sendMail(person: Person, message: String) {
        println("Connecting to SendGrid server...")
        println("Connecting successfully")
        println("Sending mail to ${person.mail} with message: $message")
    }
}

class SmtpMailService : IMailService {
    override fun sendMail(person: Person, message: String) {
        println("Connecting to SMTP server...")
        println("Connecting successfully")
        println("Sending mail to ${person.mail} with message: $message")
    }
}

abstract class Register(private val mailService: IMailService, private val domainServer: String) : IMailService {
    abstract fun getDataUser(): Person

    override fun sendMail(person: Person, message: String) {
        mailService.sendMail(person, message)
    }

    fun submit() {
        val person = getDataUser()
        sendMail(person, "Hello ${person.name}")
    }
}

class MessengerRegister(private val mailService: IMailService, domainServer: String) : Register(mailService, domainServer) {
    override fun getDataUser(): Person {
        return Person("Dung", "dungmanh74@gmail.com")
    }
}

fun main() {
    val sendGridMailService = SendGridMailService()
    val smtpMailService = SmtpMailService()

    val messengerRegister1 = MessengerRegister(sendGridMailService, "example.com")
    messengerRegister1.submit()

    val messengerRegister2 = MessengerRegister(smtpMailService, "example.com")
    messengerRegister2.submit()
}
