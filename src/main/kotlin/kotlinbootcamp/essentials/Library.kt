package kotlinbootcamp.function.essentials


//practice collection

 fun main() {
    val allBooks = setOf("A","B","C","D","E")
     val library = mapOf("William" to allBooks)

     println(library.any(){ it.value.contains("C")})
     val moreBooks= mutableMapOf("William tell" to "schiller")

     moreBooks.getOrPut("scooooelr"){"kilping"}
     moreBooks.getOrPut("JungleBooks") {"humans"}

     println(moreBooks);
 }