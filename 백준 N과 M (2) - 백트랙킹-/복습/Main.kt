import java.util.*

internal var isVisited: BooleanArray? = null
internal var num: IntArray? = null
internal var n: Int = 0
internal var m: Int = 0

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    isVisited = BooleanArray(m + 1)
    num = IntArray(m + 1)
    dfs(1, -1)
}

internal fun dfs(current: Int, prevNum: Int) {
    var prevNum = prevNum
    if (current > m) {
        for (i in 1..m) {
            print(num!![i].toString() + " ")
        }
        println()
        return
    }
    for (i in 1..n) {
        if (isVisited!![current]) {
            continue
        }
        if (prevNum >= i) {
            continue
        }
        isVisited!![current] = true
        num?.set(current, i)
        prevNum = i
        dfs(current + 1, prevNum)
        isVisited!![current] = false
    }
}