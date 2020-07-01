package KotlinBootCamp.Function.Essentials


//learn about Pair
fun main(){
    val equipment= "fishnet" to "catching fish"

    println(equipment.first)

    println(equipment.second)

    val equipment2 = "fishnet" to "catching fish" to "of bif size" to "and strong"

    println(equipment2)

    //in REPL
    equipment2.first
    equipment2.first.second

    val fishnet = "fishnet" to "catching fish"

    //destruction
    val (tool,use)= fishnet

    println("The $tool is a tool for $use")

    println(fishnet.toString())
    println(fishnet.toList())

    fun giveMeATool():Pair<String, String>{
        return ("fishnet" to "catching")
    }

    val (tool2,use2)=giveMeATool();
    println("$tool2 ans $use2")


}