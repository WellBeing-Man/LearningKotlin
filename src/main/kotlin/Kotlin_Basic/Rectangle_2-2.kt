package Kotlin_Basic.shape          // It doesn't need to be correspond with directory

import java.util.Random         //Java Library import

//Written by LDH

//how property make accessor

class Rectangle(val height:Int, val width:Int){
    val isSquare : Boolean
        get() {                 //property getter
        return height==width
    }
    // or get()=height==width
}

//REPL
// val rectangle= Rectangle(41,43)
// println(rectangle.isSquare)

fun createRandomRectangle(): Rectangle {            //this function is imported
    val random=Random()
    return Rectangle(random.nextInt(), random.nextInt())
}