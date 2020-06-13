package Kotlin_Function

// "String" is receiver type, "this" is receiver object
fun String.lastChar() : Char = this.get(this.length-1)

//println("Kotlin".lastChar())
// String is receiver type and "Kotlin" is receiver object
//also able to omit "this"
fun String.lastChar2() : Char=get(length-1)

//extended function has private or protected access modifier so it doesn't hurt encapsulation