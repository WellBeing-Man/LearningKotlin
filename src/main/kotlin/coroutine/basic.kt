package coroutine

import kotlinx.coroutines.*
import org.jetbrains.annotations.TestOnly
import kotlin.concurrent.thread


suspend fun main(){
    coroutine()
    //coroutine2()
    //waitJob()
    //scoped()
   // scopeBuilder()
  // refactoring()
   //dot()
    //tDot()
   // daemonThread()
}

fun coroutine(){
     GlobalScope.launch {               //coroutine scoped whole main thread
        delay(1000L)            //suspended waiting for 1 second
        println("world")
    }
    println("Hello")
    Thread.sleep(2000L)             //block main thread for 2 seconds

    //upper code is same as below
    runBlocking {                       // this expression means block the main thread
        delay(2000L)            //for 2 seconds
    }
    println("Hello again")
}

/*
Here runBlocking<Unit> { ... } works as an adaptor that is used to start the top-level main coroutine.
We explicitly specify its Unit return type, because a well-formed main function in Kotlin has to return Unit.
 */
fun coroutine2()= runBlocking<Unit>{  // it mean block the main thread
    GlobalScope.launch {              //launch new coroutine
        delay(1000L)
        println("world")
    }
    println("Hello")                  //main coroutine continue here
    delay(2000L)        //delaying
}
// it also a way to write test for suspending function
class Mytext{
    fun testSuspendFunction()= runBlocking {
        //
    }
}

suspend fun waitJob(){
    val job=GlobalScope.launch {
        delay(1000L)
        println("world")
    }
    println("Hello")
    job.join()      //wait until child coroutine complete
}

fun scoped() = runBlocking {
    launch { delay(1000L)       //for every coroutine builder, including runBlocking,
    println("world")                    //have own coroutine scope, CoroutineScope
    }                                   //we can launch coroutines without join
    println("Hello")                    //because outer coroutine does not complete until all coroutines launched
}


fun scopeBuilder()= runBlocking {
    launch {
        delay(200L)
        println("Task run from runBlocking")
    }
    coroutineScope {
        launch {
            delay(500L)
            println("Task run from nested launch")
        }

        delay(100L)
        println("Task run from coroutineScope")   // it print order by delay time, because it is suspended
    }
    println("coroutine scope is over")           //it will be not printed until nested launch complete
}                                                //because runBlocking is block main thread


fun refactoring() = runBlocking {
    doWorld()
    println("Hello")
}

suspend fun doWorld() {         //suspend function
    delay(1000L)
    println("World")
}


//it could be done but with thread, it is not.
fun dot()= runBlocking {
    repeat(100_000){
        launch {
            delay(5000L)
            print(".")
        }
    }
}

// it can be...?
fun tDot()= thread {
    repeat(100_000){
        Thread.sleep(5000L)
        print(".")
    }
}


//GlobalScoped coroutines are like daemon threads so when thread done, they finish
suspend fun daemonThread(){
    GlobalScope.launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // after delay , return to main function
}