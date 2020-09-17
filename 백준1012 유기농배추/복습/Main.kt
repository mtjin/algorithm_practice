import java.util.*

internal var M = 0 //배추밭 가로길이
internal var K = 0 //배추가 심어져 있는 위치의 개수
private var map: Array<IntArray>? = null
private var isVisited: Array<BooleanArray>? = null
private var N = 0 //배추밭 세로길이
private var result = 0 //지렁이개수
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val T = sc.nextInt()
    for (t in 0 until T) {
        result = 0
        M = sc.nextInt()
        N = sc.nextInt()
        map = Array(N + 2) { IntArray(M + 2) }
        isVisited = Array(N + 2) { BooleanArray(M + 2) }
        K = sc.nextInt()
        for (i in 0 until K) {
            val y = sc.nextInt() + 1
            val x = sc.nextInt() + 1
            map!![x][y] = 1
        }
        for (i in 1..N) {
            for (j in 1..M) {
                if (!isVisited!![i][j] && map!![i][j] == 1) {
                    bfs(i, j)
                    result++
                }
            }
        }
        println(result)
    }
}

fun bfs(x: Int, y: Int) {
    val queue = LinkedList<Point>()
    queue.offer(Point(x, y))
    isVisited!![x][y] = true
    while (!queue.isEmpty()) {
        val point = queue.poll()
        for (i in 0..3) {
            val x2 = point.x + dx[i]
            val y2 = point.y + dy[i]
            if (map!![x2][y2] == 1 && !isVisited!![x2][y2]) {
                isVisited!![x2][y2] = true
                queue.offer(Point(x2, y2))
            }
        }
    }
}

data class Point(var x: Int, var y: Int)


