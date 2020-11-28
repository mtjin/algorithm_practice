import java.util.*


private lateinit var map: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private var N = 0
private var sRow = 0
private var sCol = 0
private var answer = 0
private var sharkSize = 2
private var eatSize = 0
private val dr = intArrayOf(-1, 0, 0, 1)
private val dc = intArrayOf(0, -1, 1, 0)

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    map = Array(N) { IntArray(N) }
    isVisited = Array(N) { BooleanArray(N) }
    for (i in 0 until N) {
        for (j in 0 until N) {
            map[i][j] = sc.nextInt()
            if (map[i][j] == 9) {
                sRow = i
                sCol = j
            }
        }
    }
    while (true) { //5
        if (!bfs(sRow, sCol)) break
    }
    println(answer)
}

// 1.물고기 탐색
private fun bfs(r: Int, c: Int): Boolean {
    isVisited = Array(N) { BooleanArray(N) }
    isVisited[r][c] = true
    val queue: Queue<Point> = LinkedList()
    queue.offer(Point(r, c, 0))
    val eatList = ArrayList<Point>() //잡아먹을 수 있는 물고기 리스트
    var tmpMove = 401 //이동거리( 물고기 먹은 경우의 이동경로 이후로 탐색을 그만하기 위한 flag)
    while (!queue.isEmpty()) {
        val point = queue.poll()
        for (i in 0..3) {
            val r2 = point.r + dr[i]
            val c2 = point.c + dc[i]
            if (r2 in 0 until N && c2 >= 0 && c2 < N && !isVisited[r2][c2] && tmpMove > point.move && sharkSize >= map[r2][c2]) { //크기가 같거나 작은거만 지나갈 수 있다.
                isVisited[r2][c2] = true
                if (map[r2][c2] < sharkSize && map[r2][c2] != 0) { //2. 아기상어가 먹을 수 있는 물고기
                    eatList.add(Point(r2, c2, point.move + 1))
                    tmpMove = point.move + 1 //최초로 발견한 물고기 이동거리(이 이동거리보다 큰 거는 탐색 멈춤)
                    break
                } else { //계속 탐색이동
                    queue.offer(Point(r2, c2, point.move + 1))
                }
            }
        }
    }
    //3. 잡아먹은 물고기가 있다면 우선순위인 놈 잡아먹음(가장 상단인 놈 다음엔 왼쪽 기준)
    eatList.sortWith(Comparator { o1: Point, o2: Point ->
        return@Comparator if (o1.r == o2.r) {
            o1.c - o2.c
        } else {
            o1.r - o2.r
        }
    })
    //4. 잡아먹은 물고기 있다면 처리해줌
    if (eatList.isNotEmpty()) {
        val r2 = eatList[0].r
        val c2 = eatList[0].c
        eatSize++ //먹은개수 + 1
        answer += eatList[0].move
        map[r][c] = 0 //처음 자기위치 리셋
        map[r2][c2] = 0 //먹은 물고기 처리
        if (eatSize == sharkSize) { //레벨업 체크
            sharkSize++
            eatSize = 0
        }
        sRow = r2
        sCol = c2
        return true
    }
    return false
}

private class Point internal constructor(var r: Int, var c: Int, var move: Int)