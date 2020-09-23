import java.util.*

private val dx = intArrayOf(0, 0, -1, 1)
private val dy = intArrayOf(-1, 1, 0, 0)
private var N: Int = 0 //수빈이 위치
private var M: Int = 0 //동생 위치
private var map: Array<IntArray>? = null
private var isVisited: Array<Array<BooleanArray>>? = null //x,y, (0:안부심,1:부심)


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    map = Array(N + 2) { IntArray(M + 2) }
    isVisited = Array(N + 2) { Array(M + 2) { BooleanArray(2) } }
    for (i in 1..N) {
        val line = sc.next()
        for (j in 0 until M) {
            map!![i][j + 1] = line[j] - '0'
        }
    }
    //바깥쪽 멥은 -1로 세팅 (사방히막힌 경우 구하기위해)
    for (i in 0 until M + 2) { //왼쪽,오른쪽벽
        map!![0][i] = -1
        map!![N + 1][i] = -1
    }
    for (i in 0 until N + 2) {
        map!![i][0] = -1
        map!![i][M + 1] = -1
    }
    bfs(1, 1)
}

private fun bfs(x: Int, y: Int) {
    val queue = LinkedList<Point>()
    //초깃값도 이동경로개수 포함
    queue.offer(Point(x, y, 0, 1))
    isVisited!![x][y][0] = true
    isVisited!![x][y][1] = true

    while (!queue.isEmpty()) {
        val point = queue.poll()
        if (point.x == N && point.y == M) {
            println(point.distance)
            return
        }
        for (i in 0..3) {
            val x2 = point.x + dx[i]
            val y2 = point.y + dy[i]
            val destroyCnt = point.destroyCnt
            val distance = point.distance
            if (map!![x2][y2] == 1) { //이동할 곳이 벽인 경우
                if (point.destroyCnt == 0 && !isVisited!![x2][y2][1]) { //벽부순적이없고 방문한적이 없던 곳
                    isVisited!![x2][y2][1] = true
                    queue.offer(Point(x2, y2, destroyCnt + 1, distance + 1))
                }
            } else if (map!![x2][y2] != -1) { // 이동할 곳이 벽이 아닌 경우( + 쓰레기외부값아닌경우)
                if (!isVisited!![x2][y2][destroyCnt]) {
                    isVisited!![x2][y2][destroyCnt] = true
                    queue.offer(Point(x2, y2, point.destroyCnt, distance + 1))
                }
            }
        }
    }
    println(-1)
}

internal class Point(var x: Int, var y: Int, var destroyCnt: Int //부순 벽개수
                     , var distance: Int // 이동한 개수
)


