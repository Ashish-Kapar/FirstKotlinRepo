import kotlin.system.exitProcess

var data: MutableMap<String,String> = mutableMapOf()


fun main(){
    println("This is a program where you can manage your emails and passwords")
    while(true){
        processE(interfaceM())
    }
}

fun interfaceM(): Int{
    var response : Int
    while (true){
        println("-----------------------------------------")
        println(" | 1. Add an account")
        println(" | 2. Remove an account")
        println(" | 3. Display an account")
        println(" | 4. Exit")
        println("-----------------------------------------")
        response = readlnOrNull()?.toIntOrNull() ?: 4

        if (response in 1..4){
            return response
        }
        else{
            println("Please make sure the given argument is between 1 and 4\n")
            continue
        }
    }
}

fun processE(n: Int){
    var pair: Pair<String, String>
    when (n) {
        1 -> {
            pair = inputE(n)
            addE(pair)
        }
        2 -> {
            pair = inputE(n)
            removeE(pair.first)
        }
        3 -> {
            displayE()
        }
        else -> {
            println("Program successfully closed")
            exitProcess(0)
        }
    }
}



fun inputE(n:Int): Pair<String,String>{
    var email: String
    var password: String
    var response: Int
    while (true){
        print("Enter your email: ")
        email = readln()
        print("Enter your password: ")
        password= readln()
        response = checkE(email,password,n)
        if (response == 0){
            return Pair(email,password)
        }
    }
}



fun addE(pair: Pair<String,String>) {
    data[pair.first] = pair.second
    println("Your account was successfully added \n")
}

fun removeE(email: String) {

    if (email in data.keys){
        println("Your account was removed successfully")
    }
    else{
        println("Sorry but the email doesnt exist")
    }
    data.remove(email)
}


fun displayE() {
    println("Accounts & Passwords")
    println("$data \n")
}

fun checkE(email: String,password: String,n:Int): Int{

    if (n!=2){
        if (email in data.keys){
            println("The given email already exists")
            return 1
        }
        if ("." in email && "@" in email){
            // email before @ should have at least 5 characters and...
            // after that the minimum u can get is @edu.com
            if (password.count()>=8){
                return 0
            }
            println("Please have a longer password")
            return 1
        }
        println("Make sure your email is correct")
        return 1
    }
    else{
        return 0
    }
}