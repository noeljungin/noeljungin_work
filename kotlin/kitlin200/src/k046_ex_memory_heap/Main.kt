package k046_ex_memory_heap

fun main(args:Array<String>)
{
    val person = object
    {
        val name: String = "jamie"
        val age: Int = 36
    }
    println(person.name)
    println(person.age)
}