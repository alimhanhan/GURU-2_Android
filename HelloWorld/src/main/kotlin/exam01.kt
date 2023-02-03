fun main() {
    var var1 : Int = 10
    var var2 : Float = 10.1f
    var var3 : Double = 10.2
    var var4 : Char = '안'
    var var5 : String = "안드로이드"
    println(var1)
    println(var2)
    println(var3)
    println(var4)
    println(var5)

    //초기값을 지정해주는 경우는 아래처럼 변수의 데이터 형식을 써주지 않아도 된다.
    var var6 = 20
    var var7 = "문자열"
    println(var6)
    println(var7)

    var a : Int = "100".toInt()
    var b : Double = "100.123".toDouble()
    println(a)
    println(b)
}

