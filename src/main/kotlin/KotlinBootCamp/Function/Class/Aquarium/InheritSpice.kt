package KotlinBootCamp.Function.Class.Aquarium

import Kotlin_Function.list
import sun.security.provider.ConfigFile
import KotlinBootCamp.Function.Class.Aquarium.Grinder as Grinder

sealed abstract class Spice2(val name:String,val spiciness:String="mild") :SpiceColor{
    private val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }
    abstract fun prepareSpice()
}
class Curry(name: String,spiceColor: SpiceColor=YellowSpiceColor):Spice2(name), Grinder,SpiceColor by YellowSpiceColor {
    override fun prepareSpice() {
        TODO("Not yet implemented")
    }

    override fun grind() {
        TODO("Not yet implemented")
    }

}

interface Grinder{
    fun grind()
}

interface SpiceColor{
    val color:Color
}
object YellowSpiceColor:SpiceColor{
    override val color:Color=Color.YELLOW
}

data class SpiceContainer(var spice: Spice2){
    val label=spice.name
}

enum class Color(val rgb:Int){
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}
fun main() {
    val curry:Spice2=Curry("Curry")
    println(curry.color)

    val spiceContainer= listOf(
        SpiceContainer(Curry("YellowCurry")),
        SpiceContainer(Curry("GreenCurry")),
        SpiceContainer(Curry("ChickenCurry"))
    )

    for(element in spiceContainer){
        println(element.label)
    }
}
