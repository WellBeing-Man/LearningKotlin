//Written by LDG
//there is no for loop in kotlin

package kotlinbasic

import java.util.*

fun FizzBuzz(i:Int) =when{
    i % 15==0 -> "FizzBuzz "
    i % 3==0 -> "Fizz "
    i % 5==0 -> "Buzz "
    else -> "$i"
}

object Run {
    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 1..100) {       //open range 1 to 100
            println(FizzBuzz(i))
        }
        /*
    for(i in 100 downTo 1 step 2){          //from 100 to 1, step 2 like 100 98 96....
        println(FizzBuzz(i))
    }

     */

        val binaryReps = TreeMap<Char, String>()    //to sort key... use TreeMap
        for (c in 'A'..'F') {
            val binary = Integer.toBinaryString(c.toInt())
            binaryReps[c] = binary
        }

        for ((letter, binary) in binaryReps) {
            println("$letter = $binary")
        }


        val  list= arrayListOf("10","11","1001")
        for((index,element) in list.withIndex()){
            println("$index: $element")
        }

        fun isLetter(c:Char) = c in 'a'..'z' || c in 'A'..'Z'       //amazing
        fun isNotDigit(c:Char)= c !in '0'..'9'

        println(isLetter('q'))
        println(isNotDigit('x'))


        fun recognize(c:Char) = when(c){
            in '0'..'9' -> "It's a digit!"
            in 'a'..'z', in 'A'..'z' -> "It's a letter!"
            else -> "I don't know.."
        }

        print(recognize('8'))
    }
}