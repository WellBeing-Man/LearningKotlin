package kotlinbootcamp.function.Class.Aquarium

fun main() {
    makeDecoration()
}

fun makeDecoration(){
 val d1=Decoration("granite")
 val d2=Decoration("Slate")
 val d3=Decoration("Slate")
 val d4=d3.copy()

    println(d1)
    println(d2)
    println(d3)
    println(d4)
    println(d1.equals(d2))
    println(d2.equals(d3))

    val d5=Decoration2(rock = "Crystal",wood="wood",diver="diver")
    println(d5)
    val (rock,wood,diver)=d5
    println(rock)
    println(wood)
    println(diver)
}

data class Decoration(val rock:String){

}

data class Decoration2(val rock:String,val wood:String, val diver:String){

}