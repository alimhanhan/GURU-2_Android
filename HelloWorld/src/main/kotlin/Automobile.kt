open class Car2
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