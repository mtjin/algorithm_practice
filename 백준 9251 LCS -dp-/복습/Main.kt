import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val line1 = sc.next()
    val line2 = sc.next()
    val lcs = Array(line1.length + 1) { IntArray(line2.length + 1) }
    for (i in 1..line1.length) {
        for (j in 1..line2.length) {
            if (line1[i - 1] == line2[j - 1]) {
                lcs[i][j] = lcs[i - 1][j - 1] + 1
            } else {
                lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1])
            }
        }
    }
    println(lcs[line1.length][line2.length])
}