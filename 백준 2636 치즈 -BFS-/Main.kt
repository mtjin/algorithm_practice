import java.util.*


private var R = 0
private var C = 0
private var time = 0
private var remainCheese = 0
private lateinit var map: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private var cheese: Int = 0
private var dr = arrayOf(-1, 0, 1, 0)
private var dc = arrayOf(0, -1, 0, 1)
fun main() {
    val sc = Scanner(System.`in`)
    R = sc.nextInt()
    C = sc.nextInt()
    map = Array(R) { IntArray(C) }
    for (i in 0 until R) {
        for (j in 0 until C) {
            map[i][j] = sc.nextInt()
            if (map[i][j] == 1) { // 치즈 총 개수 저장
                cheese++
            }
        }
    }
    while (cheese > 0) { // 치즈가 다 녹을 때 까지 반복
        time++ // 녹을때마다 시간 업
        remainCheese = cheese //치즈 다 녹기 전 치즈개수 세팅해야함
        bfs() // 공기 닿는 치즈 녹이기
    }
    println(time)
    print(remainCheese)
}

fun bfs() {
    val queue: Queue<Point> = LinkedList<Point>()
    queue.offer(Point(0, 0))
    isVisited = Array(R) { BooleanArray(C) }
    isVisited[0][0] = true
    while (queue.isNotEmpty()) {
        val point = queue.poll()
        for (i in 0..3) {
            val r = point.r + dr[i]
            val c = point.c + dc[i]
            if ((r in 0 until R && c in 0 until C) && !isVisited[r][c]) {
                if (map[r][c] == 0) { // 공기인경우 공기로 더 탐색
                    queue.offer(Point(r, c))
                } else if (map[r][c] == 1) { // 치즈인 경우 녹임
                    cheese--
                    map[r][c] = 0
                }
                isVisited[r][c] = true
            }
        }
    }
}

data class Point(val r: Int, val c: Int)