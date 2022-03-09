import java.util.*


private var N = 0
private val op = IntArray(4)
private lateinit var arr: IntArray
private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    arr = IntArray(N)
    for (i in 0 until N) {
        arr[i] = sc.nextInt()
    }
    for (i in 0..3) {
        op[i] = sc.nextInt()
    }
    dfs(1, op, arr[0])
    println(max)
    println(min)
}

private fun dfs(depth: Int, op: IntArray, result: Int) {
    if (depth == N) {
        max = Math.max(max, result)
        min = Math.min(min, result)
        return
    }
    for (i in 0..3) {
        if (op[i] == 0) {
            continue
        }
        op[i]--
        when (i) {
            0 -> dfs(depth + 1, op, result + arr[depth])
            1 -> dfs(depth + 1, op, result - arr[depth])
            2 -> dfs(depth + 1, op, result * arr[depth])
            3 -> dfs(depth + 1, op, result / arr[depth])
        }
        op[i]++
    }
}
