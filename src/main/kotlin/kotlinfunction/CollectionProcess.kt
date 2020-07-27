//written by LDG



package kotlinfunction

//#1 varargs

//listOf code..
/*
fun listOf<T>(vararg values:T):List<T>{...
}
*/

//#2 spread
fun main(args:Array<String>) {
    val list= listOf("args: ", *args)
    println(list)
}
//main(arrayOf("Wow","how"))


//#3 infix and destructing declaration
val map1 = mapOf(1 to "one", 2 to "two", 53 to "fifty-three")
//"to" is special keyword, called infix


//allow to function to use infix,

infix fun Any.to(other:Any)=Pair(this,other)
//this to return Pair instance

//destructing declaration
//val (number,name) = 1 to "one"

//in loop
/*
for((index, element)) in collection.withIndex()){
    println("$index: $element")
}
*/
