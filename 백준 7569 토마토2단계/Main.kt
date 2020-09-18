import java.util.*

private var N: Int = 0 //1차원
private var M: Int = 0 //2차원
private var H: Int = 0 //3차원
private var map: Array<Array<IntArray>>? = null
private val dx = intArrayOf(-1, 0, 1, 0, 0, 0)
private val dy = intArrayOf(0, -1, 0, 1, 0, 0)
private val dz = intArrayOf(0, 0, 0, 0, -1, 1)
private val resultTreeSet = TreeSet<Int>()
private val queue = LinkedList<Point>()


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    M = sc.nextInt()
    N = sc.nextInt()
    H = sc.nextInt()
    map = Array(N + 2) { Array(M + 2) { IntArray(H + 2) } }
    //바깥쪽 세팅을 위한 for 문 (테두리가 아닌 값도 세팅해서 시간오버플로우가 생기긴함)
    for (i in 0 until N + 2) {
        for (j in 0 until M + 2) {
            for (k in 0 until H + 2) {
                map!![i][j][k] = -1
            }
        }
    }
    for (k in 1..H) {
        for (i in 1..N) {
            for (j in 1..M) {
                map!![i][j][k] = sc.nextInt()
                if (map!![i][j][k] == 1) {
                    queue.offer(Point(i, j, k))
                }

            }
        }
    }

    //탐색
    bfs()
    for (i in 1..N) {
        for (j in 1..M) {
            for (k in 1..H) {
                if (map!![i][j][k] == 0) { //익지 못하는 상황
                    println(-1)
                    return
                }
            }
        }
    }
    if (resultTreeSet.isEmpty()) { // 모드 토마토가 익어있는 상태
        println(0)
    } else {
        println(resultTreeSet.pollLast()!! - 1)
    }
}

fun bfs() {
    while (!queue.isEmpty()) {
        val point = queue.poll()
        for (i in 0..5) {
            val x2 = point.x + dx[i]
            val y2 = point.y + dy[i]
            val z2 = point.z + dz[i]
            if (map!![x2][y2][z2] == 0) {
                map!![x2][y2][z2] = map!![point.x][point.y][point.z] + 1
                resultTreeSet.add(map!![x2][y2][z2])
                queue.offer(Point(x2, y2, z2))
            }
        }
    }
}

data class Point(var x: Int, var y: Int, var z: Int)