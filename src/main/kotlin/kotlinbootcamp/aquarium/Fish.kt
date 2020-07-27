package kotlinbootcamp.function.Class.Aquarium

class Fish(val friendly:Boolean=true,volumeNedded:Int){
    val size:Int
    init {
        println("init first block")
    }
    constructor(): this(friendly=true,volumeNedded = 9){
        println("running secondary constructor")
    }

    init {
        if(friendly){
            size=volumeNedded
        }else{
            size=volumeNedded*2
        }
    }
    init {
        println("constructor fish of size $volumeNedded")
    }

}

fun main(){
    val fish=Fish(true,20)
    println("Is the fish friendy? ${fish.friendly}. It need volume ${fish.size}")
    val fish2=Fish()
}
