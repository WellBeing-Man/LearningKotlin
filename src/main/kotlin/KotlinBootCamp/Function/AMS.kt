//written by LDG
//this is kotlin bootcamp of UACTIVITY
package KotlinBootCamp.Function

import Kotlin_Function.numbers
import java.util.*;

fun main(args:Array<String>) {
    println("Hello ${args[0]}")

    feedFish()


    //practice
    var fortune: String
    var i: Int = 0;
    repeat(10) {
        fortune = getFortune(getBirthday())
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy"));
    }


    //practice4
    println(whatShouldDoToday("happy"))
}



fun feedFish(){
    val day= randomDay()
    val food=fishFood(day)

    println("Today is $day and th fish eat $food")
}

fun fishFood(day: String): String {
    if(shouldChangeWater("day")){
        println("Should Change Water")
    }
   return when(day){
       "Monday" -> "flakes"
       "Tuesday"-> "redworms"
       "Wednesday" -> "granules"
       "Thursday"->"mosquitos"
       "Friday"->"plankton"
       "Saturday"-> "meat"
       "Sunday"->"grass"
       else -> "fasting"
   }
}

fun shouldChangeWater(
    day:String,
    temp:Int=22,
    dirty:Int=20): Boolean{
    return true
}
fun randomDay():String{
    val weeks= listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    return weeks[Random().nextInt(7)]
}


//practice
fun getFortuneCookie():String{
    val cookies= listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")

    print("Enter your birthday")

    val birthday= readLine()?.toIntOrNull() ?:1

    return cookies[birthday.rem(cookies.size)]
}

//practice2
fun getFortune(birthday: Int): String {

    val cookies= listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")

   return when(birthday){
        in 1..7 ->  cookies[birthday]
        28 -> cookies[0]
        31 -> cookies[1]
       else -> cookies[birthday.rem(cookies.size)]
    }
}

fun getBirthday(): Int = readLine()?.toIntOrNull() ?: 0


//practice3
fun canAddFish(
    tankSize:Double,
    currentFish:List<Int>,
    fishSize:Int=2,
    hasDecoration:Boolean=true):Boolean {
    return   (if (hasDecoration) tankSize * 0.8 else tankSize) > currentFish.sum()+fishSize
}


//practice4
fun whatShouldDoToday(
    mood:String,
    weather:String="sunny",
    temperature:Int=24):String{
     return when{
        mood=="happy" && weather=="sunny"-> "go out"
        mood=="sad" && weather=="cloudy" -> "Stay home"
        temperature>40 -> "Get some coll drinks"
        temperature<0 -> "make it warm"
         mood == "sad" && weather == "rainy" && temperature == 0 -> "stay in bed"
         temperature > 35 -> "go swimming"
        else ->"Stay home"
    }
}

//practice5
fun isVeryHot (temperature: Int) = temperature > 35
fun isSadRainyCold (mood: String, weather: String, temperature: Int) =
    mood == "sad" && weather == "rainy" && temperature == 0
fun isHappySunny (mood: String, weather: String) = mood == "happy" && weather == "sunny"

fun whatShouldDoToday2(
    mood:String,
    weather:String="sunny",
    temperature:Int=24):String{
    return when{
        isVeryHot(temperature) -> "go swimming"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isHappySunny(mood, weather) -> "go for a walk"
        else -> "Stay home and read."
    }
}


//practice6 lamda

val rolldice = {Random().nextInt(12)+1}
val rolldice2= {number:Int->Random().nextInt(number)+1}
val rolldice3={number:Int->if(number==0) 0 else Random().nextInt(number)+1}
val rolldice4:(Int)->Int ={ number-> if(number==0) 0 else Random().nextInt(number)+1}

//REPL Code
//gamePlay(rolldice4(4))
fun gamePlay(rolldice:Int){
    println(rolldice)
}
