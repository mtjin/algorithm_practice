import java.util.*

internal var isVisited: BooleanArray? = null
internal var num: IntArray? = null
internal var n: Int = 0
internal var m: Int = 0
internal var sb = StringBuilder()

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    isVisited = BooleanArray(m + 1)
    num = IntArray(m + 1)
    dfs(1, -1)
    println(sb)
}

internal fun dfs(current: Int, prev: Int) {
    if (current > m) {
        for (i in 1..m) {
            sb.append(num!![i]).append(" ")
        }
        sb.append("\n")
        return
    }
    for (i in 1..n) {
        if (prev > i) {
            continue
        }
        num!![current] = i
        dfs(current + 1, i)
    }
}