import kotlin.system.exitProcess

var data: MutableMap<String,String> = mutableMapOf()
var tempMap: MutableMap<String,String> = mutableMapOf()

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
        response = readLine()!!.toInt()
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
    tempMap= mutableMapOf()
    when (n) {
        1 -> {
            tempMap = inputE(n)
            addE(tempMap.keys, tempMap.values)
        }
        2 -> {
            tempMap = inputE(n)
            removeE(tempMap.keys)
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

fun inputE(n:Int): MutableMap<String,String>{
    var email: String
    var password: String
    var response: Int
    val myMap: MutableMap<String,String> = mutableMapOf()
    while (true){
        print("Enter your email: ")
        email = readLine()!!.toString()
        print("Enter your password: ")
        password= readLine()!!.toString()
        response = checkE(email,password,n)
        if (response == 0){
            myMap[email] = password
                return myMap
        }
    }
}



fun addE(keys: MutableSet<String>, values: MutableCollection<String>) {
    data[keys.toString()] = values.toString()
    println("Your account was successfully added \n")

}

fun removeE(keys: MutableSet<String>) {
    var keyT: String

    for (key in keys){

        keyT = "[${key}]"
        if (keyT in data.keys){

            println("Your account was removed successfully")

        }
        else{
            println("Sorry but the email doesnt exist")
        }
        data.remove(keyT)
    }

}

fun displayE() {
    println("Accounts & Passwords")
    println("$data \n")

}

fun checkE(email: String,password: String,n:Int): Int{
    if (n!=2){
        if ("[$email]" in data.keys){
            println("The given email already exists")
            return 1
        }
        if ("." in email && "@" in email){
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


