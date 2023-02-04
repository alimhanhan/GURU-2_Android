open class Car
{
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
    {}

    companion object
    {
        var carCount : Int = 0
        const val MAXSPEED : Int = 200
        const val MINSPEED : Int = 0
        fun currentCarCount():Int{
            return carCount
        }
    }

    open fun upSpeed(value: Int)
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

class Automobile : Car
{
    var seatNum : Int = 0

    constructor()
    {}
    fun countSeatNum():Int{
        return seatNum
    }

    override fun upSpeed(value: Int) {
        if (speed+value>=300)
        {
            speed = 300
        }
        else
        {
            speed += value
        }
    }
}