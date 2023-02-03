fun sum(a: Int, b: Int): Int
{
    var sum = a+b
    return sum
}

fun main()
{
    val result1: Int
    val result2: Int

    result1 = sum(3, 2)
    result2 = sum(6, 7)

    println(result1)
    println(result2)
}