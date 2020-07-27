//Written by LDG
//making collection

package kotlinfunction

import java.lang.StringBuilder

//#1 collection declaring
val set= hashSetOf(1,3,53)
val list= arrayListOf(1,7,53);
val map= hashMapOf( 1 to "one", 7 to "seven", 53 to "fifty-three")
/*  check about class
 println(set.javaClass)
 println(list.javaClass)
 println(map.javaClass)
 */



//#2 nice tools
val strings= listOf<String>("first","second","fourteen")
val numbers=listOf(1,14,2)
/*
     println(strings.last())
     println(numbers.max())
 */


//#3 custom toString

// joinToString elementary implement
fun <T> joinToString(
    collection:Collection<T>,
    separator:String,
    prefix:String,
    postfix:String
):String{
    val result=StringBuilder(prefix)

    for((index,element) in collection.withIndex()){
        if(index>0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

val listInt= listOf<Int>(1,2,3)


//println(joinToString(listInt,";","(",")"))

// to make sure parameter
//println(joinToString(listInt,separator = ",",prefix = "",postfix = ""))

//#4 Default parameter
//add default parameter
fun <T> joinToStringDefault(
    collection:Collection<T>,
    separator:String=",",
    prefix:String="",
    postfix:String=""
):String{
    val result=StringBuilder(prefix)

    for((index,element) in collection.withIndex()){
        if(index>0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//so we don't need to overload too much
/*
joinToStringDefault(listInt,",","","")
 joinToStringDefault(list)
 joinToStringDefault(list,";")
 */