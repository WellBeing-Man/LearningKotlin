//written by LDG
//SmartCast

//think about tree
package kotlinbasic

interface Expr                              //empty interface
class Num(val value: Int) : Expr            //leaf node
class Sum(val left:Expr, val right:Expr) : Expr  //not-leaf node..... but return Expr-it means, Sum can be argument itself


fun eval(e:Expr):Int{
    if(e is Num){
        val n = e as Num        //as Num is unnecessary
        return n.value
    }
    if(e is Sum){
        return eval(e.right)+ eval(e.left)      //smart cast
    }
    throw IllegalArgumentException("Unknown Argument")
}



fun evalOptimized(e:Expr):Int=       //turn if to when
    when(e){
        is Num ->
            e.value
        is Sum ->
            eval(e.right)+ eval(e.left)
        else ->
            throw IllegalArgumentException("Unkown Argument")
    }


fun evalWithLoggin(e:Expr) : Int =
    when(e){
        is Num->{
            println("num:${e.value}")
            e.value                 //return value
        }
        is Sum ->{
            val left = evalWithLoggin(e.left)
            val right= evalWithLoggin(e.right)
            println("sum:$left+$right")
            left+right
        }
        else ->
            throw IllegalArgumentException("Unknown Argument")
    }