package Kotlin_Basic
//Written by LDG
//First Time with Kotlin


//How to use Function
fun main(args :Array<String>){
    //#1 function without return

    println("Hello World!")   //Hello world!
    //#2 function with return
    // function name        parameter     return type
            fun max       (a:Int, b:Int):      Int{
        return if (a>b) a else b
    }
    // 'if' is not a statement, it is expression

    //more concisely
    // fun max(a:Int, b:Int) = if (a>b) a else b

    //#3 variable
    val question = "Ultimate question about Life,Space, everything"
    val answer : Int
    answer=42
    val yearsToCompute = 7.5e6                            //val is immutable  just like 'final'
    var life="UnExpectable";                                                  //var is mutable;


    val message:String                                  //val is mutable in each block once
    if(canPerformOperation()){
        message="Success"
    }else{
        message="Failed"
    }


    val languages= arrayListOf("Java")          // able to change value, but unable to change reference
    languages.add("Kotlin")
    val match:Int
    // match="no answer";         //type mismatch error


    //#4 String template
    var name= if(args.size>0) args[0] else "Kotlin"
    println("Hello, $name");   //String template

    println("\$x")                      // escape \, it print $x

    if(args.size>0){
        println("Hello, ${args[0]}!")       //{} is useful when handling complex phrase
    }

    val 한글 : String         //wow we can use korean
    한글="Korean"
    println(한글);

    println("Hello, ${if (args.size>0) args[0] else "Kotlin"}!")
}

fun canPerformOperation(): Boolean {
    return true;
}