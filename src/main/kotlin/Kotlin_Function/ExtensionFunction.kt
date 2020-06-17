package Kotlin_Function

import java.lang.StringBuilder


// "String" is receiver type, "this" is receiver object
fun String.lastChar() : Char = this.get(this.length-1)

//println("Kotlin".lastChar())
// String is receiver type and "Kotlin" is receiver object
//also able to omit "this"
fun String.lastChar2() : Char=get(length-1)

//extended function has private or protected access modifier so it doesn't hurt encapsulation


//when import extension method, we call only these method
// import Kotlin_Function.lastChar as last
// can call other name by use "as" keyword

//in java ...
//char c=ExtensionFunctionKt.lastChar("java")


//joinToString last version

fun <T> Collection<T>.joinToString( //extension function
    separator:String=",",
    prefix:String="",
    postfix:String=""               //default parameter
):String{
    val result= StringBuilder(prefix)

    for((index,element) in this.withIndex()){
        if(index>0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//var list=listOf(1,2,3)
// println(list.joinToString(""))


//if want "join" method only <String>type,
fun Collection<String>.join(
    separator: String=",",
    prefix: String="",
    postfix: String=""
)=joinToString(separator,prefix,postfix)


//println(listOf("one","two","three","four").join(" "))


//extension method can not overrode
open class View{
    open fun click()= println("View Clicked")
}

class Button:View(){
    override fun click() = println("Button Clicked")
}

fun View.showOff()=println("I'm a View")
fun Button.showOff()=println("I'm a button")

//val view=Button()
// view.click()
// view.showOff()