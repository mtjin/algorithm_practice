import java.util.*


private var N: Int = 0 //1차원
private var M: Int = 0 //2차원
private var map: Array<IntArray>? = null
private var isVisited: Array<BooleanArray>? = null
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    map = Array(N + 2) { IntArray(M + 2) }
    isVisited = Array(N + 2) { BooleanArray(M + 2) }
    for (i in 0 until N) {
        val line = sc.next()
        for (j in 0 until line.length) {
            val num = line[j] - '0'
            map!![i + 1][j + 1] = num
        }
    }
    bfs(1, 1)
    println(map!![N][M])
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
                map!![x2][y2] = map!![point.x][point.y] + 1
            }
        }
    }
}

data class Point(var x: Int, var y: Int)



