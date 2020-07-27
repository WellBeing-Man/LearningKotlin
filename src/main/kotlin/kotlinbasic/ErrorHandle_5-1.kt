//Written by LDG
//Error handling
package kotlinbasic

import java.io.BufferedReader
import java.lang.NumberFormatException

object errorRun{
    @JvmStatic
    fun main(args: Array<String>) {
        val percentage=1

        if(percentage !in 0..100)(
        throw IllegalArgumentException(
            "A percentage value must be between 0 and 100: $percentage"
        )
        )
    }

    val number=40
    val percentage =
        if(number in 0..100)
            number
        else
            throw IllegalArgumentException(   //"throw" is expression
                "A percentage value must be between 0 and 100: $number"
            )

    // there is no 'throws' claws
    fun readNumber(reader: BufferedReader): Int?{
        try {
            val line = reader.readLine()
            return Integer.parseInt(line)
        }
        catch (e: NumberFormatException){
            return null
        }

        finally {
            reader.close()
        }
    }

    //using try as expression
    fun kotreadNumber(reader: BufferedReader){
        val number=try {
            Integer.parseInt(reader.readLine())
        }catch (e:NumberFormatException){
            null
        }
        println(number)
    }
}