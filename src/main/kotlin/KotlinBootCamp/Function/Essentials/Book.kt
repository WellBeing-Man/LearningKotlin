package KotlinBootCamp.Function.Essentials

import java.time.Year
//practice Pair and Triple
class Book(val title:String,val author:String, val year: String) {

    fun AY():Pair<String,String>{
        return author to year
    }

    fun TAY():Triple<String,String,String>{
        return Triple(title,author,year)
    }


}

    fun main(){
        val book=Book("X","Y","Z");
        println("Here is  your book written in ${book.AY().first} by ${book.AY().second}")
        println("Here is  your book ${book.TAY().first} written in ${book.TAY().third} by ${book.TAY().second}")
}