import java.util.*

internal var map: Array<IntArray> = emptyArray()
internal var isVisited: Array<BooleanArray> = emptyArray()
internal var N = 0 //정사각형 크기
internal var totalNumOfHouse = 0
internal var result: ArrayList<Int> = ArrayList()
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    map = Array(N + 2) { IntArray(N + 2) }
    isVisited = Array(N + 2) { BooleanArray(N + 2) }
    for (i in 1..N) {
        val line = sc.next()
        for (j in 1..N) {
            map[i][j] = line[j - 1] - '0'
        }
    }

    for (i in 1..N) {
        for (j in 1..N) {
            if (!isVisited[i][j] && map[i][j] == 1)
                bfs(i, j)
        }
    }
    println(totalNumOfHouse)
    result.sort()
    for (i in result) {
        println(i)
    }
}

internal fun bfs(x: Int, y: Int) {
    var size = 1
    val queue = LinkedList<Point>()
    queue.offer(Point(x, y))
    isVisited[x][y] = true
    totalNumOfHouse++
    while (!queue.isEmpty()) {
        val point = queue.poll()
        for (i in 0..3) {
            val x2 = point.x + dx[i]
            val y2 = point.y + dy[i]
            if (map[x2][y2] == 1 && !isVisited[x2][y2]) {
                isVisited[x2][y2] = true
                size++
                queue.offer(Point(x2, y2))
            }
        }
    }
    result.add(size)
}

data class Point(var x: Int, var y: Int)

