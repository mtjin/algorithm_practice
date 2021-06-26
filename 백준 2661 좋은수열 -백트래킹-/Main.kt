import java.util.*
import kotlin.system.exitProcess


lateinit var arr: IntArray
var n: Int = 0
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    arr = IntArray(n)
    dfs(0, "")
}

fun dfs(depth: Int, num: String) {
    if (depth == n) {
        println(num)
        exitProcess(0) // 가장 작은수 발견 종료
    }
    for (i in 1..3) {
        if (check(num + i)) {
            dfs(depth+1, num + i)
        }
    }
}

// 좋은 수열인지 검사
fun check(num: String): Boolean {
    for (i in 1..num.length / 2) {
        val left = num.substring(num.length - i * 2, num.length - i)
        val right = num.substring(num.length - i, num.length)
        if (left == right) return false
    }
    return true
}
