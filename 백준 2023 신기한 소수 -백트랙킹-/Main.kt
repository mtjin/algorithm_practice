import java.util.*


private var N = 0
private val sb = StringBuilder()
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    dfs("", 0)
    println(sb.toString())
}

private fun dfs(num: String, depth: Int) {
    if (depth == N) {
        sb.append(num).append("\n")
        return
    }
    for (i in 1..9) {
        val currentNum = (num + i).toInt()
        if (isPrime(currentNum)) {
            dfs(currentNum.toString() + "", depth + 1)
        }
    }
}

private fun isPrime(n: Int): Boolean { // 0, 1
    if (n < 2) return false
    // 2
    if (n == 2) return true
    for (i in 2 until n) { // 소수 X
        if (n % i == 0) return false
    }
    return true
}