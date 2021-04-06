import java.util.*

private var R // 행
        = 0
private var C // 열
        = 0
private val dr = intArrayOf(-1, 0, 1, 0)
private val dc = intArrayOf(0, -1, 0, 1)
private lateinit var map // 맵
        : Array<CharArray>
private lateinit var isVisited // 방문여부
        : Array<BooleanArray>
private var answer = -1

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    R = sc.nextInt()
    C = sc.nextInt()
    map = Array(R) { CharArray(C) }
    for (i in 0 until R) {
        val str = sc.next()
        for (j in str.indices) {
            map[i][j] = str[j]
        }
    }
    for (i in 0 until R) {
        for (j in 0 until C) {
            isVisited = Array(R) { BooleanArray(C) }
            if (map[i][j] == 'L') {
                bfs(i, j)
            }
        }
    }
    println(answer)
}

private fun bfs(r: Int, c: Int) {
    val queue: Queue<Point> = LinkedList()
    queue.offer(Point(r, c, 0))
    isVisited[r][c] = true
    while (!queue.isEmpty()) {
        val point = queue.poll()
        for (i in 0..3) {
            val r2 = point.r + dr[i]
            val c2 = point.c + dc[i]
            if (r2 in 0 until R && 0 <= c2 && c2 < C && map[r2][c2] == 'L' && !isVisited[r2][c2]) {
                isVisited[r2][c2] = true
                queue.offer(Point(r2, c2, point.cnt + 1))
                answer = answer.coerceAtLeast(point.cnt + 1)
            }
        }
    }
}

data class Point(var r: Int, var c: Int, var cnt: Int)
