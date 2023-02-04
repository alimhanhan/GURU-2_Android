abstract class Animal
{
    var name : String = ""
    abstract fun move()
}

interface iAnimal
{
    abstract fun eat()
}

class iCat : iAnimal
{
    override fun eat() {
        println("생선을 좋아한다.")
    }
}

class iTiger : Animal(), iAnimal
{
    override fun move() {
        println("네 발로 이동한다.")
    }

    override fun eat() {
        println("멧돼지를 잡아먹는다.")
    }
}

class Tiger : Animal()
{
    var age : Int = 0
    override fun move() {
        println("네 발로 이동한다.")
    }
}

class Eagle : Animal()
{
    var home : String = ""
    override fun move() {
        println("날개로 날아간다.")
    }
}

fun main()
{
    var cat = iCat()
    cat.eat()

    var tiger = iTiger()
    tiger.move()
    tiger.eat()
    
    var tiger1 = Tiger()
    var eagle1 = Eagle()

    tiger1.move()
    eagle1.move()
}