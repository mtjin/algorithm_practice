import java.util.*

private var N = 0
private lateinit var map: Array<IntArray>
private lateinit var distances: Array<IntArray>
private val dr = intArrayOf(-1, 0, 1, 0)
private val dc = intArrayOf(0, -1, 0, 1)


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var testCnt = 0
    while (true) {
        N = sc.nextInt()
        if (N == 0) return
        map = Array(N) { IntArray(N) }
        distances = Array(N) { IntArray(N) }
        for (i in 0 until N) {
            for (j in 0 until N) {
                map[i][j] = sc.nextInt()
                val INF = Int.MAX_VALUE
                distances[i][j] = INF
            }
        }
        println("Problem " + ++testCnt + ": " + bfs())
    }
}

fun bfs(): Int {
    val queue = PriorityQueue<Point>()
    queue.add(Point(0, 0, map[0][0]))
    distances[0][0] = map[0][0]
    while (!queue.isEmpty()) {
        val point = queue.poll()
        val r = point.r
        val c = point.c
        for (i in 0..3) {
            val r2 = r + dr[i]
            val c2 = c + dc[i]
            if (r2 >= 0 && c2 >= 0 && r2 < N && c2 < N && distances[r2][c2] > distances[r][c] + map[r2][c2]) { // 해당 지점까지의 최소거리라면 갱신
                distances[r2][c2] = distances[r][c] + map[r2][c2]
                queue.add(Point(r2, c2, distances[r2][c2]))
            }
        }
    }
    return distances[N - 1][N - 1]
}

internal class Point(var r: Int, var c: Int, var cost: Int) : Comparable<Point?> {

    override fun compareTo(other: Point?): Int {
        return cost - other!!.cost
    }

}