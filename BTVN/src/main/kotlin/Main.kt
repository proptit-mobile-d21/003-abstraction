data class Person(val name: String, val mail: String)

interface IMailService {
    fun sendMail(person: Person, message: String, domainServer: String)
}

class SendGridMailService : IMailService {
    override fun sendMail(person: Person, message: String, domainServer: String) {
        println("Connecting to SendGrid server...")
        println("Connecting successfully to $domainServer")
        println("Sending mail to ${person.mail} with message: $message")
    }
}

class SmtpMailService : IMailService {
    override fun sendMail(person: Person, message: String, domainServer: String) {
        println("Connecting to SMTP server...")
        println("Connecting successfully to $domainServer")
        println("Sending mail to ${person.mail} with message: $message")
    }
}

abstract class Register(private val mailService: IMailService, private val domainServer: String) : IMailService {
    abstract fun getDataUser(): Person

    override fun sendMail(person: Person, message: String, domainServer: String) {
        mailService.sendMail(person, message, domainServer)
    }

    fun submit() {
        val person = getDataUser()
        sendMail(person, "Hello ${person.name}", domainServer)
    }
}

class MessengerRegister(private val mailService: IMailService, domainServer: String) : Register(mailService, domainServer) {
    private val listPerson = listOf<Person>(
        Person("Dung1", "dungmanh1@gmail.com"),
        Person("Dung2", "dungmanh2@gmail.com"),
        Person("Dung3", "dungmanh2@gmail.com")
    )
    override fun getDataUser(): Person {
        val i = (0..2).random()
        return listPerson[i]
    }
}

fun main() {

    val sendGridMailService = SendGridMailService()
    val smtpMailService = SmtpMailService()

    val messengerRegister1 = MessengerRegister(sendGridMailService, "Sever1")
    messengerRegister1.submit()

    val messengerRegister2 = MessengerRegister(smtpMailService, "Sever2")
    messengerRegister2.submit()
}
