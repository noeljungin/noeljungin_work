package k047_ex_class

class Person
{
    var name: String = ""
    var age: Int = 0
}

fun main(args:Array<String>)
{
    val person: Person

    person = Person()
    person.name = "jamie"
    person.age = 36

    val person2 = Person()
    person.name = "claire"
    person.age = 29

    val person3 = Person()
    person.name = "john"
    person.age = 52

}