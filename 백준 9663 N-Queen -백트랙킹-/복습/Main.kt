import java.util.*

internal var n: Int = 0
internal var result = 0

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    for (i in 1..n) {
        val num = IntArray(n + 1)
        num[1] = i
        dfs(num, 1)
    }
    println(result)
}

internal fun dfs(num: IntArray, row: Int) {
    if (row == n) {
        result++
        return
    }
    for (j in 1..n) {
        num[row + 1] = j
        if (check(num, row + 1)) {
            dfs(num, row + 1)
        }
    }
}

internal fun check(num: IntArray, row: Int): Boolean {
    for (i in 1 until row) {
        if (num[i] == num[row]) { //같은열존재
            return false
        }
        if (Math.abs(i - row) == Math.abs(num[i] - num[row])) { //대각선존재
            return false
        }
    }
    return true
}