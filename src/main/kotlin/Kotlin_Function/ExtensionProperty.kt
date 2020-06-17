//wriiten by LDG

//extension property
package Kotlin_Function

//extention property
val String.lastChar:Char
    get() =get(length-1)


//mutable extension property
var StringBuilder.lastChar:Char
    get() =get(length-1)            //property getter
    set(value:Char){
        this.setCharAt(length-1,value)  //property setter
    }

/*
 println("Kotlin".lastChar)
 val sb=StringBuilder("Kotlin?")
 sb.lastChar="!"
 println(sb)
 */