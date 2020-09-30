import java.util.*

internal var N: Int = 0
internal var M: Int = 0
internal var isVisited: BooleanArray? = null
internal var num: IntArray? = null


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    isVisited = BooleanArray(N + 1)
    num = IntArray(N + 1)
    dfs(1)

}

internal fun dfs(current: Int) {
    if (current > M) {
        for (i in 1..M) {
            print(num!![i].toString() + " ")
        }
        println()
        return
    }
    for (i in 1..N) {
        if (isVisited!![i]) {
            continue
        }
        isVisited!![i] = true
        num!![current] = i
        dfs(current + 1)
        isVisited!![i] = false
    }
}


