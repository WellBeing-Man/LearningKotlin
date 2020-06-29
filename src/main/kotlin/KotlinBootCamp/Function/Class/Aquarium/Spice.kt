//practice

package KotlinBootCamp.Function.Class.Aquarium

class SimpleSpice {
    val name: String = "curry"
    val spiciness: String="mild"

    val heat:Int
        get()=getheat(spiciness)

    private fun getheat(spiciness: String): Int {
                return 5
    }
}


class Spice(val name:String,val spiciness:String="mild") {
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


    fun main() {
        val spices = listOf(
            Spice("curry", "mild"),
            Spice("pepper", "medium"),
            Spice("cayenne", "spicy"),
            Spice("ginger", "mild"),
            Spice("red curry", "medium"),
            Spice("green curry", "mild"),
            Spice("hot pepper", "extremely spicy")
        )

        val spice = Spice("cayenne", "spicy")
        val spacelist = spices.filter { it.heat < 5 }




    }

    fun makeSalt() = Spice("Salt")
}


