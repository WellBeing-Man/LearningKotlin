//written by LDG
//ENUM CLASS


package Kotlin_Basic

import java.lang.IllegalArgumentException

enum class Color(
    val r:Int, val g:Int, val b:Int         //property declare
)
{              //enum class it also called "soft keyword"
    RED(255,0,0), ORANGE(255,165,0),YELLOW(255,255,0),GREEN(0,255,0),
    BLUE(0,0,255), INDIGO(75,0,130),VIOLET(238,130,238);                //need semi-colon

    fun rgb()=(r*256+g)*256+b       //method
}

fun getMnemonic(color: Color) =             //Just like switch-case
    when (color){
        Color.RED->"Richard"
        Color.BLUE->"Battle"
        Color.GREEN->"Gave"
        Color.INDIGO->"In"
        Color.ORANGE->"Of"
        Color.VIOLET->"Vain"
        Color.YELLOW->"York"
    }

fun getWarmth(color: Color) =
    when(color){
        Color.RED,Color.ORANGE,Color.YELLOW->"warm"         // by using ','
        Color.GREEN->"neutral"
        Color.VIOLET,Color.INDIGO,Color.BLUE->"cold"
    }
// we can use ENUM Class at other package


fun mix(c1:Color, c2:Color)=
    when(setOf(c1,c2)){                 //we can use any kind of Object in when clause
        setOf(Color.RED,Color.YELLOW)->Color.ORANGE
        setOf(Color.YELLOW,Color.BLUE)->Color.GREEN
        setOf(Color.BLUE,Color.VIOLET)->Color.INDIGO
        else -> throw Exception("Dirty Color")      //if there were no matches,
    }

fun mixOptimized(c1: Color, c2: Color)=
    when{                                   //when without factor
        (c1==Color.RED && c2==Color.YELLOW) ||
                (c1==Color.YELLOW && c2==Color.RED)->
            Color.ORANGE
        (c1==Color.YELLOW && c2==Color.BLUE)||
                (c1==Color.BLUE && c2==Color.YELLOW)->
            Color.GREEN
        (c1==Color.BLUE && c2==Color.VIOLET) ||
                (c1==Color.VIOLET && c2==Color.BLUE)->
            Color.INDIGO
        else ->
            throw Exception("Dirty Color")
    }