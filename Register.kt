data class User(val name: String, val phoneNumber: String, val emailAdress: String)

interface verificationSerice{
    fun sendOTP(user: User)
}

class emailService : verificationSerice{
    override fun sendOTP(user: User) {
        println("Sending an OTP code to ${user.name} through the email: ${user.emailAdress}!")
    }
}

class SMS_Service: verificationSerice{
    override fun sendOTP(user: User) {
        println("Sending an OTP code to ${user.name} through phone number: ${user.phoneNumber}!")
    }
}

class callService: verificationSerice{
    override fun sendOTP(user: User) {
        println("Calling directly to ${user.name} to show OTP code!")
    }
}

abstract class Register{
    abstract fun getDataFromUser(): User
    abstract val verification: verificationSerice
    fun submit(){
        val data = getDataFromUser()
        verification.sendOTP(data)
    }
}

class storeOwner : Register(){
    override val verification: verificationSerice = callService()
    override fun getDataFromUser(): User {
        val ownerDemo = User("NMinh", "0123456789", "nminh@gmail.com")
        return ownerDemo
    }

}

class Cashier : Register(){
    override val verification: verificationSerice = emailService()
    override fun getDataFromUser(): User {
        val cashierDemo = User("Xuyen", "0321456789", "xuyen@gmail.com")
        return cashierDemo
    }
}

class Buyer: Register(){
    override val verification: verificationSerice = SMS_Service()
    override fun getDataFromUser(): User {
        val buyerDemo = User("Chi", "0987654321", "chi@gmail.com")
        return buyerDemo
    }
}

fun main()
{
    val owner = storeOwner()
    owner.submit()
    val cashier = Cashier()
    cashier.submit()
    val buyer = Buyer()
    buyer.submit()
}

