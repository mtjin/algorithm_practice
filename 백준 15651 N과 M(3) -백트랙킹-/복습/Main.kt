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
    dfs(1)
    println(sb)
}

internal fun dfs(current: Int) {
    if (current > m) {
        for (i in 1..m) {
            sb.append(num?.get(i)).append(" ")
        }
        sb.append("\n")
    } else {
        for (i in 1..n) {
            num?.set(current, i)
            dfs(current + 1)
        }
    }
}