package k045_exobject

fun main(args: Array<String>)
{
    val person = object
    {
        val name: String = "jamie"
        val age: Int = 36
    }
    println(person.name)
    println(person.age)
}