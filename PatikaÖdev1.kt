package patika

import apple.laf.JRSUIConstants.Size
import com.sun.xml.internal.fastinfoset.util.StringArray
import java.io.File
import java.nio.file.*
import java.util.*

fun main() {

    // Sayfa 9
    println("Hello World")

    // Sayfa 10
    println(minus(5, 3))
    multiply(9, 7)

    // Sayfa 11
    val aNum1 = 5
    var aNum2 = 3

    var aNum3: String
    aNum3 = "Hello"

    println(minus(aNum1, aNum2))

    // Sayfa 12
    Circle("Circle", "Red").draw()
    Circle("Circle", "Red").mFill()

    // Sayfa 13
    val str1 = "Hello"
    println("String Length: ${str1.length}, First Char: ${str1.replace("H", "J")}")

    // Sayfa 15 - Sayfa 58
    if (aNum1 > aNum2) {
        println("aNum1 is greater than aNum2")
    } else if (aNum1 == aNum2) {
        println("aNum1 is equal to aNum2")
    } else {
        println("aNum2 is greater than aNum1")
    }


    // Sayfa 15
    val aNum4 = if (aNum1 > aNum2) aNum1 else aNum2

    val aList = listOf("one", "two", "three", "four")

    for (i in aList) {
        println(i)
    }


    // Sayfa 17 - 83
    while (aNum2 - 2 < aNum1 + 5) {
        println(aNum2)
        aNum2++
    }


    // Sayfa 18 - Sayfa 81
    when (aNum4) {
        aNum1 -> println("aNum1 ")
        aNum2 -> println("aNum2")
        !is Int -> println("aNum4 is not an integer")
        else -> println("aNum4 is not aNum1, aNum2")
    }


    // Sayfa 19
    val list = listOf("a", "b", "с")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }

    // Ranges - Until - Sayfa 85
    for (i in 1 until 10) {
        print(i)
    }

    // Sayfa 86
    if (list.size in list.indices) {
        println("list size is out of valid list indices range, too")
    }

    // Sayfa 86
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }

    // Sayfa 82
    for (x in 1..5) {
        print(x)
    }

    for (x in 1..10) {
        print(x)
    }

    for (x in 9 downTo 0 step 3) {
        print(x)
    }

    // Sayfa 20 - Sayfa 42
    val fruitList = listOf("apple", "banana", "cherry", "kiwi")

    fruitList.filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase(Locale.getDefault()) }
        .forEach {
            println(it)
        }


    // Sayfa 21 - Sayfa 72 - Sayfa 73
    var aNullable: String? = null
    aNullable = "Hello"
    if (aNullable != null) {
        println(aNullable.length)
    } else {
        println("aNullable is null")
    }

    if (aNullable is String) {
        println(aNullable.length)
    }


    // Sayfa 24

    // Adlandırma kuralları kısmı için dosyanın içindeki değişkenler,fonksyionlar (vb) için
    // adlandırma kurallarına dikkat edilmiştir.

    /**
     * Annotation : @Test @Inject @HiltAndroidApp
     * Class : Shape, Circle
     * Fun : minus, multiply
     * Modifiers : open, override, infix, const
     * Parameter : val aParam: String, val bParam: String = "Parameter"
     * Flows : if, else, when, for, while, try, catch, finally
     * Variable(Değişken) : aNum1, aNum2, aNum3, aNum4
     */

    // Sayfa 60
    fun foo() = 2 // Single-Expression

    // -----------------------------------------------------------------------------------------------

    // Idioms

    // Sayfa 43
    val map = mapOf("a" to 1, "b" to 2, "c" to 3)


    // Sayfa 44
    for ((k, v) in map) {
        println("$k -> $v")
    }

    // Sayfa 45
    val aLazyValue: String by lazy {
        println("First computed!")
        "Hello"
    }

    "Hello".removeFirstLastChar()

    ConcreteClass().doSomething()

    // Sayfa 46 - Sayfa 50
    val files = File("Test").listFiles()
    println(files?.size ?: "empty")
    val filesSize = files?.size ?: println("empty")

    println(filesSize)


    // Sayfa 51
    val exception = aLazyValue ?: throw IllegalArgumentException("aLazyValue is null")
    val fruitFirst: String? = null ?: fruitList.firstOrNull()

    // Sayfa 52
    fruitFirst?.let {
        println(it)
    }

    // Java 7 - Sayfa 63
    val stream = Files.newInputStream(Paths.get("/some/file.txt"))
    stream.buffered().reader().use { reader ->
        println(reader.readText())
    }

    // Sayfa 68
    5 plus 3

    // do - while
    var x1 = 10
    do {
        x1--
        println(x1)
    } while (x1 > 0)

    // Equality Check - Sayfa 88
    val num1: Short = 127
    val boxedNum1: Short? = num1 ?: null
    val anotherNum1: Short? = num1 ?: null

    val num2 = 128
    val boxedNum2: Int? = num2 ?: null
    val anotherNum2: Int? = num2 ?: null

    println("Num1 Reference : ${boxedNum1 === anotherNum1}") // true
    println("Num2 Reference : ${boxedNum2 === anotherNum2}") // false

    // Sayfa 90
    User(1, "John", 25, "", "").toString()
    User(1, "John", 25, "", "").equals(User(1, "John", 25, "", ""))
    User(1, "John", 25, "", "").hashCode()
    User(1, "John", 25, "", "").copy(
        id = 2,
        name = "Jane"
    )

    // Sayfa 61
    val student = Student("John", 25, "")

    with(student) {
        println(name)
        for (i in 1..5) {
            println(i)
        }
        println(email)
    }

}

// Sayfa 10
fun minus(a: Int, b: Int): Int {
    return a - b
}

fun multiply(a: Int, b: Int) = println(a * b)

// Sayfa 12
open class Shape(open val name: String, open val color: String) {
    open fun draw() {
        println(name)
    }

    fun fill2() {
        println(color)
    }
}

// Sayfa 12 - Sayfa 78
class Circle(override val name: String, override val color: String) : Shape(name, color) {
    override fun draw() {
        println("Drawing a $name")
    }

    fun mFill() {
        println("Filling a $color")
    }
}


// -----------------------------------------------------------------------------------------------

// Idioms

// DTO (Data Transfer Object) - Sayfa 37
data class User(
    val id: Int,
    val name: String,
    val age: Int,
    val email: String,
    val address: String
)

// Data Class - Sayfa 88 - Sayfa 92
data class Student(val name: String, val age: Int, val email: String) {

    operator fun component13(): String {
        return name
    }

    operator fun component5(): Int {
        return age
    }

    fun copyTwo(name: String = this.name, age: Int = this.age, email: String = this.email) = Student(name, age, email)
}

// Default Parameters - Sayfa 38
fun createUser(
    email: String,
    address: String = "No Address"
) = println(email + address)

// Extension Functions - Sayfa 46
fun String.removeFirstLastChar() = this.substring(1, this.length - 1)

// Singleton Object - Sayfa 47
object Singleton {
    fun doSomething() {
        println("Singleton")
    }
}

// Abstract Classes - Sayfa 48
abstract class AbstractClass {
    abstract fun doSomething()
}

class ConcreteClass : AbstractClass() {
    override fun doSomething() {
        println("Concrete Class")
    }
}

// When - Return - Sayfa 55
fun color(color: String): Int {
    return when (color) {
        "Red" -> 1
        "Green" -> 2
        "Blue" -> 3
        else -> 0
    }
}

// Try-Catch - Sayfa 56 - Sayfa 57

// Try-catch ifadesi kullanım olarak bir if-else ifadesi gibidir. Ancak kod karamaşıklığı fazla olan bir yapıdır.
// Ancak Android tarafında çokça kullanılan ve bence control operasyonları yapmak için bunu yapmak mantıklı olabilir.
// Örneğin bir API'dan veri çekerken, veri çekme işlemi başarısız olursa, kullanıcıya bir hata mesajı göstermek için kullanılabilir.
// UseCase ve ya Repository katmanında kullanılabilir.

fun tryCatch() {
    val result = try {
        1 / 0
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }
}

// fill() - Sayfa 59
fun fillFunc(size: Int) : IntArray {
    return IntArray(size).apply {
        fill(5)
    }
}

// Scope Functions

// apply - Sayfa 62
val shape = Shape("Circle", "Red").apply {
    draw()
    fill2()
}

// also - Sayfa 65
val shape2 = Shape("Circle", "Red").also {
    it.draw()
    it.fill2()
}

// Generic - Sayfa 64
fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val list = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) {
            list.add(item)
        }
    }
    return list
}

// Generic Class - Sayfa 75
class GenericClass<T>(val value: T) {
    fun get(): T {
        return value
    }

    fun peek(): T {
        return value
    }

    fun isEmpty(): Boolean {
        return value == null
    }
}

// Infix - Sayfa 68
infix fun Int.plus(a: Int): Int {
    return this + a
}

// Operator - Sayfa 69
operator fun Int.minus(a: Int): Int {
    return this - a
}

// vararg - Sayfa 70
fun printAll(vararg messages: String) {
    for (m in messages) {
        println(m)
    }
}

