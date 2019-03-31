package K030

fun main(args : Array<String>): Unit
{
    println(myFunction())
    println(myFunction() + 10)
}

fun myFunction() : Int
{
    val a = 3
    val b = 6
    println("K037.getA" + a + " b" + b)
    return a + b
}