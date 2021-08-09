import java.util.*


private var N // 로봇 움직일 횟수
        = 0
private val directions = DoubleArray(4) // 각 방향의 이동확률 (동서남북순)
private val dr = intArrayOf(1, -1, 0, 0) // 동서남북순으로 directions 와 맞춰준다. 안그럼 틀림
private val dc = intArrayOf(0, 0, 1, -1)
private val isVisited = Array(100) { BooleanArray(100) }
private var answer = 0.0


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    for (i in 0..3) { // 각 방향 이동 확률 초기화  (이동할 확률을 모두 더하면 100이다.)
        directions[i] = 0.01 * sc.nextInt()
    }
    isVisited[50][50] = true
    dfs(50, 50, 1.0)
    println(answer)
}

private fun dfs(r: Int, c: Int, p: Double) {
    if (N == 0) { // 다움직임
        answer += p // 로빗의 이동경로 단순할 확률업
        return
    }
    for (i in 0..3) {
        val r2 = r + dr[i]
        val c2 = c + dc[i]
        if (!isVisited[r2][c2] && directions[i] > 0) { // 0인 이동확률도 제외해줘야함
            N--
            isVisited[r2][c2] = true
            dfs(r2, c2, p * directions[i]) // 이동 , 확률 더해줌
            N++
            isVisited[r2][c2] = false
        }
    }
}
