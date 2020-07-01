package KotlinBootCamp.Function.Essentials

fun main() {
    val symptoms:MutableList<String> = mutableListOf("white spots","red spots","not eating","belly up")

    symptoms.add("black spots")
    symptoms.remove("black spots")

    symptoms.contains("red") //false
    symptoms.contains("red spots")// true

    println(symptoms.subList(3,symptoms.size)) //belly up


    listOf(1,5,3).sum() // 9
    listOf("a","b","cc").sumBy { it.length } //4

    val cures:Map<String,String> = mapOf("white spot" to "Ich", "red sore" to "hole disease")
    println(cures.get("white spot"))
    println(cures["white spot"])

    println(cures.getOrDefault("bloating","sorry I don't know"))


    cures.getOrElse("bloatin"){"No cure for this"}

    val inventory:MutableMap<String,Int> = mutableMapOf("fishnet" to 1)
    inventory.put("tubber tank",3)
    inventory.remove("fishnet")
}