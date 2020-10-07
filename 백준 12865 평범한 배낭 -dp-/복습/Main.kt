import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val dp = Array(n + 1) { IntArray(k + 1) }
    val weight = IntArray(n + 1)
    val value = IntArray(n + 1)
    for (i in 1..n) {
        weight[i] = sc.nextInt()
        value[i] = sc.nextInt()
    }
    for (i in 1..n) {
        for (j in 1..k) {
            dp[i][j] = dp[i - 1][j]
            if (j - weight[i] >= 0) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i])
            }
        }
    }
    println(dp[n][k])
}