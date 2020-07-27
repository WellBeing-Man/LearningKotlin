package coroutine

import kotlinx.coroutines.*


fun main() {
   // dispatchers()
    //debugging()
   // jumpToOther()
   // coContext()
  //  child()
    //parent()
   // naming()
    multiContext()
}

fun dispatchers()= runBlocking {
    launch {
        println("Main runBlocking : I'm working in ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined){
        println("Unconfined : I'm working in ${Thread.currentThread().name}")
    }
    //this is equal to GlobalScope.launch
    launch(Dispatchers.Default){
        println("Default :  : I'm working in ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("MyownThread")) {
        println("newSingleThread :  : I'm working in ${Thread.currentThread().name}")
    }
}


//below function means that unconfined coroutine starts a coroutine in the caller thread
// After suspension it resumes the coroutine in the thread that is fully determined by the suspending function

fun confinedDispatcher()= runBlocking {
    launch(Dispatchers.Unconfined){
        println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
        delay(500)
        println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
    }
    launch {
        println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
        delay(1000)
        println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
    }
}
//but  The unconfined dispatcher should not be used in general code.



//when debugging mode is on, we can see identifier in Thread name
fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
fun debugging()= runBlocking {
    val a=async { log("I'm computing a piece of the answer")
    6
                }
    val b= async {
        log("I'm computing another piece of the answer")
        7
    }
    log("Ths answer is ${a.await() * b.await()}")
}



//withContext function change context of coroutine
fun jumpToOther()  {
    newSingleThreadContext("Ctx1").use {
        ctx1->
        newSingleThreadContext("Ctx2").use {
            ctx2->
            runBlocking(ctx1){
                log("Start in ctx1")
                withContext(ctx2){
                    log("Working in ctx2")
                }
                log("Back to ctx1")
            }
        }
    }
}


//Job is part of coroutines context
//can be retrieved from it using the coroutineContext[Job]
fun coContext()= runBlocking {
    println("My job is ${coroutineContext[Job]}")
}
//isActive in CoroutineScope is just a convenient shortcut for coroutineContext[Job]?.isActive == true.




//GlobalScope is root, it is independent even from scope it was launched
fun child() = runBlocking<Unit> {
    // launch a coroutine to process some kind of incoming request
    val request = launch {
        // it spawns two other jobs, one with GlobalScope
        GlobalScope.launch {
            println("job1: I run in GlobalScope and execute independently!")
            delay(1000)
            println("job1: I am not affected by cancellation of the request")
        }
        // and the other inherits the parent context
        launch {
            delay(100)
            println("job2: I am a child of the request coroutine")
            delay(1000)
            println("job2: I will not execute this line if my parent request is cancelled")
        }
    }
    delay(500)
    request.cancel() // cancel processing of the request
    delay(1000) // delay a second to see what happens
    println("main: Who has survived request cancellation?")
}



//A parent coroutine always waits for completion of all its children.
// A parent does not have to explicitly track all the children it launches,
// and it does not have to use Job.join to wait for them at the end:
fun parent()= runBlocking {
    val request = launch {
        repeat(3) { i -> // launch a few children jobs
            launch  {
                delay((i + 1) * 200L) // variable delay 200ms, 400ms, 600ms
                println("Coroutine $i is done")
            }
        }
        println("request: I'm done and I don't explicitly join my children that are still active")
    }
    request.join() // wait for completion of the request, including all its children
    println("Now processing of the request is complete")
}

// CoroutineName context element serves the same purpose as the thread name.
fun naming() = runBlocking {
    log("Started main coroutine")

    val v1 = async(CoroutineName("v1coroutine")) {
        delay(500)
        log("Computing v1")
        252
    }
    val v2 = async(CoroutineName("v2coroutine")) {
        delay(1000)
        log("Computing v2")
        6
    }
    log("The answer for v1 / v2 = ${v1.await() / v2.await()}")
}

//we can define multi context by using +
fun multiContext()= runBlocking {
    launch(Dispatchers.Default + CoroutineName("test")) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
}