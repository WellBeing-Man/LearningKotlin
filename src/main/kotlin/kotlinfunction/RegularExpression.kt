//written by LDG

package kotlinfunction


fun parsePath(path:String){
    val directory=path.substringBeforeLast("/")
    val fullName=path.substringAfterLast("/")
    val fileName=fullName.substringBeforeLast(".")
    val extension=fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fullName, filename: $fileName, exstension: $extension")
}
//parsePath("D:/Study/kotlinAction/a.txt")

//using regex

fun parsePath2(path: String){
    val regex="""(.+)/(.+)\.(.+)""".toRegex()
    val matchResult=regex.matchEntire(path)
    if(matchResult!=null){
        val (directory,filename,extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext:$extension")
    }
}

val kotlinlogo="""| //
                 .| //
                 .|/ \"""
//println(