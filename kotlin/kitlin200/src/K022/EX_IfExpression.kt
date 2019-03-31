package K022

fun main(args : Array<String>): Unit
{
    val value : Int = if(10 > 5)
    {
        println("10 big than 5")
        10
    }
    else
    {
        println("5 big than 10")
        5
    }
    println(value)
}