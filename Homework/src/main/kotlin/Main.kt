const val validNumber: String = "0123456789"

data class User(val name: String, val ipAddress: String, val phoneNumber: String)

val userList = listOf<User>(
    User("T", "192.168.1.100", "0123456789"),
    User("Ta", "192.168.1.101", "0987654321"),
    User("Tam", "192.168.1.102", "0988775632")
)

interface ConfirmService {
    fun sendOTP(user: User?, code: String)
}

class SMSService : ConfirmService {
    override fun sendOTP(user: User?, code: String) {
        println("[SMS Service]: Sending an OTP to ${user?.name} (IP: ${user?.ipAddress}) with SMS code: $code")
    }
}

class CallService : ConfirmService {
    override fun sendOTP(user: User?, code: String) {
        println("[Call Service]: Sending an OTP to ${user?.name} (IP: ${user?.ipAddress}) with SMS code: $code")
    }
}

abstract class Transaction(private val confirmService: ConfirmService, private val ipAddress: String) : ConfirmService {
    abstract fun getDataFromUser(ipAddress: String): User?

    override fun sendOTP(user: User?, code: String) {
        confirmService.sendOTP(user, code)
    }

    private fun generateOTP(): String {
        var otp: String = ""
        repeat(6) {
            otp += validNumber.random()
        }
        return otp
    }

    fun submit() {
        println("[ADMIN]: A submission is sent to queue.")
        val user = getDataFromUser(ipAddress)
        if (user == null) println("[ADMIN]: Invalid IP Address. Submission was rejected.")
        else sendOTP(user = user, code = generateOTP())
    }
}

class MoneyTransaction(private val confirmService: ConfirmService, ipAddress: String) :
    Transaction(confirmService, ipAddress) {
    override fun getDataFromUser(ipAddress: String): User? {
        userList.forEach {
            if (it.ipAddress == ipAddress) return it
        }
        return null
    }
}

fun main(args: Array<String>) {
    val smsService = SMSService()
    val callService = CallService()
    val moneyTransaction1 = MoneyTransaction(smsService, "192.168.1.101")
    moneyTransaction1.submit()
    val moneyTransaction2 = MoneyTransaction(callService, "192.168.1.100")
    moneyTransaction2.submit()
    val moneyTransaction3 = MoneyTransaction(callService, "192.168.1.103")
    moneyTransaction3.submit()
}