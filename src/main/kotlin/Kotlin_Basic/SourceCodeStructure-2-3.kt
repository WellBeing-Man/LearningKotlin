//Written by LDG
//Package declaration and importing

package Kotlin_Basic  // Package

import java.util.Random          //standard java library importing

class Rectangle(val height:Int, val width:Int){
    val isSquare:Boolean
        get() = height==width
}

fun createRandomRectangle(): Rectangle{
    val random=Random()
    return Rectangle(random.nextInt(),random.nextInt())
}