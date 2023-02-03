public final class Carr {
    var color : String = ""
    var speed : Int = 0

    constructor(color: String, speed: Int)
    {
        this.color = color
        this.speed = speed
    }

    constructor(speed: Int)
    {
        this.speed = speed
    }

    constructor()
    {

    }

    companion object
    {
        var carCount : Int = 0
        const val MAXSPEED : Int = 200
        const val MINSPEED : Int = 0
        fun currentCarCount():Int{
            return carCount
        }
    }

    fun upSpeed(value: Int)
    {
        if (speed + value >= 200)
        {
            speed = 200
        }
        else
        {
            speed += value
        }}
    fun downSpeed(value: Int)
    {
        if(speed-value <=0)
        {
            speed = 0
        }
        else
        {
            speed -= value
        }
    }
}


fun main()
{
    var myCar1 : Carr = Carr("red", 0)
    myCar1.color = "red"
    myCar1.speed = 0

    var myCar2 : Carr = Carr("skyblue", 0)
    myCar2.color = "pink"
    myCar2.speed = 0

    myCar1.upSpeed(50)
    println("자동차 1의 색상은 "+myCar1.color+ "이며, 속도는"+ myCar1.speed + "km입니다.");
}