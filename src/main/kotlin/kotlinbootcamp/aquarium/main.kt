package kotlinbootcamp.function.Class.Aquarium

fun main(){
    buildAquarium()
    makeFish()
}

fun feedFish(fishAction: FishAction){
    fishAction.eat()
}
fun makeFish() {
    val shark=Shark()
    val plecostomus=Plecostomus()

    println("Shark ${shark.color}")
    println("Plecostomus ${plecostomus.color}")
    feedFish(shark)
    feedFish(plecostomus)
}

fun buildAquarium() {
    val myAquarium=Aquarium()
    println("Length : ${myAquarium.length} + " +
            "Width : ${myAquarium.width} + " +
            "Height : ${myAquarium.height} ")

    myAquarium.height=80

    println("Height : ${myAquarium.height} ")
    println("Volume : ${myAquarium.volume} ")

    val smallAquarium=Aquarium(length = 20,width = 15,height = 30)
    val smallAquarium2=Aquarium(9)

    printAquarium(smallAquarium)
    printAquarium(smallAquarium2)
}

fun printAquarium(aquarium: Aquarium){
    println(
        "Length : ${aquarium.length} + " +
            "Width : ${aquarium.width} + " +
            "Height : ${aquarium.height} ")
}


abstract class AquariumFish{
    abstract val color:String
}

class Shark() :AquariumFish(),FishAction{
    override val color: String="Gray"
    override fun eat() {
        println("hunt and eat")
    }
}

class Plecostomus:AquariumFish(),FishAction{
    override val color: String="Gold"
    override fun eat() {
       println("Munch on algae")
    }
}


interface FishAction{
    fun eat()
}


