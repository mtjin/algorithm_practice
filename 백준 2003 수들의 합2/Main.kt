import java.util.*

private lateinit var num: IntArray
private var left = 0
private var right = 0
private var result = 0
private var sum = 0


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    num = IntArray(n)
    for (i in num.indices) {
        num[i] = sc.nextInt()
    }
    while (true) {
        if (sum >= m) {
            sum -= num[left++]
        } else if (right == n) {
            break
        } else {
            sum += num[right++]
        }
        if (sum == m) {
            result++
        }
    }
    println(result)
}