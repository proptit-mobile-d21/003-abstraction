class Data(val name : String, val age : Int){

}

interface MailService{
    abstract fun sendOTP(data : Data)
}

abstract class Register : MailService{
    override fun sendOTP(data: Data) {
        println("Send OTP to ${data.name}")
    }

    abstract fun getDataFromUser() : Data

    fun submit(){
        val data = getDataFromUser()
        sendOTP(data)
    }

    lateinit var domainService : String
        get
        set

    constructor(domainService : String){
        this.domainService = domainService
    }
}

class MessengerRegister(domainService: String) : Register(domainService){
    override fun getDataFromUser(): Data {
        val demo = Data("Thuy", 8)
        return demo
    }
}

fun main(){
    val messengerRegister = MessengerRegister("VietNam")
    messengerRegister.submit()
}