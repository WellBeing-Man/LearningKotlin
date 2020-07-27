package coroutine

import kotlinx.coroutines.*
fun main() {
     //   cancellingExecution()
  //  cooperativeCancel()
    //statusCancel()
    //finallyCancel()
   // noneCancellable()
   // timeoutTrack()
    timeoutHandle()
}


fun cancellingExecution()= runBlocking {
    val job=launch {
        repeat(1000){
            i->
            println("job: I'm sleeping $i")
            delay(500L)
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting")
    job.cancel()
    job.join()                              //wait for jon complete
    println("main: Now i can quit")         //if there is no cancel(), it is not printed, and keep count
}

fun cooperativeCancel() = runBlocking {
    val startTime=System.currentTimeMillis()
    val job = launch(Dispatchers.Default){
        var nextPrintTime= startTime
        var i=0
        while (i<5){
            if(System.currentTimeMillis()>=nextPrintTime){
                println("job : I'm sleeping ${i++}")
                nextPrintTime+=500L
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()     //cancels the job and waits for its completion
    println("main: Now I can quit.")
}

fun statusCancel()= runBlocking{
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) {                               //when cancel() called, it false
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}

fun finallyCancel() = runBlocking {
    val job=launch {
        try {
            repeat(1000){
                i->
                println("job:I'm sleeping $i...")
                delay(500L)
            }
        }finally {
                println("job: I'm running finally")         //when cancel() call throw  CancellationException so
        }                                                   // finally call
    }                                         //it call after cancel(), but it still inside of job, so it could be cancel.
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}

fun noneCancellable()= runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            //with this context, None-cancellable
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")


            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}

fun timeoutTrack()= runBlocking {
    withTimeout(1300L){         //when time over it throws TimeoutCancellationException
        repeat(1000){i->
            println("I'm sleeping $i")
            delay(500L)
        }
    }
}

fun timeoutHandle()= runBlocking {
    val result=withTimeoutOrNull(1300L) {       //when timeout, return null
        repeat(1000) { i ->
            println("I'm sleeping $i")
            delay(500L)
        }
    }
    println("Result is $result")
}