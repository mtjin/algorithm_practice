import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val str = sc.nextLine()
    val minusArr = str.split("\\-".toRegex()).toTypedArray()
    var result = 0
    for (i in minusArr.indices) {
        val plusArr = minusArr[i].split("\\+".toRegex()).toTypedArray()
        for (j in plusArr.indices) {
            if (i == 0) {
                result += plusArr[j].toInt()
            } else {
                result -= plusArr[j].toInt()
            }
        }
    }
    println(result)
}