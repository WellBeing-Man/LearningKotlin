package Kotlin_Basic

//Written by LDG
class `Person_2-1`(
    val name: String,                    //val is readonly property. kotlin made private field and public getter
    var isMarried:Boolean               //Writable property. kotlin made private filed and public getter,setter
)

/*
val person = Person("Bob",true)
println(person.name)
println(person.isMarried)
 */