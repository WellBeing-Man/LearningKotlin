package coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//execute here
fun main() {
//    somethingUseful()
//    somethingUseful2()
   // somethingUseful3()
//    somethingUsefulAsync()
  //  somethingUseful4()
    fail()
}

suspend fun doSomethingUsefulOne():Int{
    delay(1000L)
    return 13
}

suspend fun doSomethingUsefulTwo():Int{
    delay(1000L)
    return 29
}

fun somethingUseful()= runBlocking {
    val time= measureTimeMillis {
        val one= doSomethingUsefulOne()
        val two= doSomethingUsefulTwo()
        println("The answer is ${one+two}")             //it invoked sequentially
    }
    println("Complete in $time ms")
}

fun somethingUseful2()= runBlocking {
    val time= measureTimeMillis {
        val one= async  { doSomethingUsefulOne()}           //async just like launch and returns deferred
        val two= async{ doSomethingUsefulTwo() }            //while launch returns Job
        println("The answer is ${one.await()+two.await()}")  //.await() deferred value and it need cancel if needed
    }
    println("Complete in $time ms")
}

fun somethingUseful3()= runBlocking {
    val time= measureTimeMillis {
        //it only starts the coroutine when its result is required by await, or if its Job's start function is invoked
        val one= async(start = CoroutineStart.LAZY){ doSomethingUsefulOne()}
        val two= async(start = CoroutineStart.LAZY){ doSomethingUsefulTwo() }
        // control is given to the programmer on when exactly to start the execution by calling start.
        one.start()
        two.start()
        println("The answer is ${one.await()+two.await()}")
    }
    println("Complete in $time ms")
}


//they are not suspending function, they can be used anywhere
fun somethingUsefulOneAsync() =GlobalScope.async {
    doSomethingUsefulOne()
}
fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo()
}

fun somethingUsefulAsync(){
    val time = measureTimeMillis {
        //we can use it without Coroutine
        //but it must involve suspending or blocking
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()
        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")
}

//upper programming style is strongly discouraged in kotlin
/*
Consider what happens if between the val one = somethingUsefulOneAsync()
line and one.await() expression there is some logic error in the code.
and program throws an exception and the operation that was being performed by the program aborts.
 Normally, a global error-handler could catch this exception, log and report the error for developers, but the program
 could otherwise  continue doing other operations.  But here we have somethingUsefulOneAsync still
 running in the background,  even though the operation that initiated it was aborted.
  This problem does not happen with structured concurrency.
 */



//with new scope assigned, if something goes wrong inside the code of the concurrentSum function
// and it throws an exception, all the coroutines that were launched in its scope will be cancelled
suspend fun concurrentSum():Int= coroutineScope {
    val one=async { doSomethingUsefulOne() }
    val two=async { doSomethingUsefulTwo() }
    one.await()+two.await()
}

fun somethingUseful4()= runBlocking{
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }
    println("Completed in $time ms")
}


//ancellation is always propagated through coroutines hierarchy
fun fail() = runBlocking<Unit> {
    try {
        failedConcurrentSum()
    } catch(e: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }
}
// first async and the awaiting parent are cancelled on failure of one of the children
suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> {
        try {
            delay(Long.MAX_VALUE) // Emulates very long computation
            42
        } finally {
            println("First child was cancelled")
        }
    }
    val two = async<Int> {
        println("Second child throws an exception")
        throw ArithmeticException()
    }
    one.await() + two.await()
}