package K019

fun main(args : Array<String>): Unit
{
    var a = 15
    var b = 11

    if (a > b)
    {
        println("in if")
        a -= b
    }
    println(a)
}