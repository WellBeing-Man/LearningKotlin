//written by LDG

package kotlinfunction

//#1 importing kotlin file without class in java
fun <T> joinToString1(
    collection:Collection<T>,
    separator:String=",",
    prefix:String="",
    postfix:String=""
):String{
    val result= StringBuilder(prefix)

    for((index,element) in collection.withIndex()){
        if(index>0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

//if want to calling jointToString1 in java
// import class JoinKT

//#2 top property

var opCount=0
fun performOperation(){
    opCount++
}
fun reportOperationCount(){
    println("Operation performed $opCount times")
}
//these properties are static

val UNIX_LINE_SEPARATOR="\n"
//making constant value

//also, top properties have access modifier method, (val have getter, var have getter and setter)

const val UNIX_LINE_SEPARATOR2="\n";
//only primary types are able to use const