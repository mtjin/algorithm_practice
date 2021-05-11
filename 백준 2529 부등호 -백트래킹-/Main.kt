import java.util.*


private var k // 부등호 문자의 개수(2 ≤ k ≤ 9)
        = 0
private val isVisited = BooleanArray(10) // 0~9 숫자방문여부 (중복숫자불가하므로)
private lateinit var signs: CharArray
private val result: MutableList<String> = ArrayList()

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    k = sc.nextInt()
    signs = CharArray(k)
    for (i in 0 until k) {
        signs[i] = sc.next()[0]
    }
    dfs("", 0)
    result.sort()
    println(result[result.size - 1]) //최댓값
    println(result[0]) //최솟값
}

private fun dfs(num: String, depth: Int) { //처음 nums를 int[]로 접근했는데 String으로 하는게 간단해진다.
    if (depth == k + 1) {
        result.add(num)
        return
    }
    for (i in 0..9) {
        if (depth == 0 || !isVisited[i] && compare(num[num.length - 1] - '0', i, signs[depth - 1])) { //처음건 비교할게없으므로 통과 || 방문안한숫자 && 비교
            isVisited[i] = true
            dfs(num + i, depth + 1)
            isVisited[i] = false
        }
    }
}

private fun compare(a: Int, b: Int, c: Char): Boolean {
    return if (c == '<') a < b else a > b
}
