import java.util.*

internal class Solution {
    private lateinit var answer: IntArray
    private val map = Array(5) { CharArray(5) }
    private var isVisited = Array(5) { BooleanArray(5) }
    private val dr = intArrayOf(-1, 0, 1, 0)
    private val dc = intArrayOf(0, -1, 0, 1)
    fun solution(places: Array<Array<String>>): IntArray {
        answer = IntArray(places.size)
        Arrays.fill(answer, 1) // 1로 초기화
        for (i in 0..4) {
            for (j in 0..4) {
                val str = places[i][j]
                for (k in str.indices) {
                    map[j][k] = str[k]
                }
            }
            for (r in 0..4) {
                var flag = true // 거리두기 지켰는지
                for (c in 0..4) { // 초기화
                    isVisited = Array(5) { BooleanArray(5) }
                    if (map[r][c] != 'X') { //벽아닌곳
                        if (!bfs(r, c, i)) { // 방 거리두기 잘 지키는지 탐색
                            flag = false
                            break // 거리두기 안지킴 -> 탐색중지
                        }
                    }
                }
                if (!flag) break // 거리두기 안지킴 -> 탐색중지
            }
        }
        for (i in 0..4) { // 정답 세팅
            println(answer[i])
        }
        return answer
    }

    private fun bfs(r: Int, c: Int, index: Int): Boolean {
        val queue: Queue<Point> = LinkedList()
        if (isPerson(r, c)) {
            queue.offer(Point(r, c, 2))
        } else {
            queue.offer(Point(r, c, 0))
        }
        isVisited[r][c] = true
        while (!queue.isEmpty()) {
            val point = queue.poll()
            for (i in 0..3) {
                val r2 = point.r + dr[i]
                val c2 = point.c + dc[i]
                if (r2 in 0..4 && c2 in 0..4 && !isVisited[r2][c2] && map[r2][c2] != 'X') { //방문안하고 벽아닌곳
// 거리두기 여부 체크
                    if (isPerson(r2, c2) && point.cnt > 0) {
                        answer[index] = 0 // 거리두기 실패
                        return false // 거리두기 실패
                    }
                    // BFS 탐색 추가
                    if (isPerson(r2, c2)) { // 사람있는 곳
                        queue.offer(Point(r2, c2, 2))
                    } else { // 사람없는 곳
                        queue.offer(Point(r2, c2, point.cnt - 1))
                    }
                    isVisited[r2][c2] = true
                }
            }
        }
        return true // 거리두기 지킴
    }

    // 사람이 앉은 자리인지
    private fun isPerson(r: Int, c: Int): Boolean {
        return map[r][c] == 'P'
    }

    internal inner class Point(var r: Int, var c: Int, cnt: Int) {
        var cnt //  사람과의 거리
                = 0

        init {
            if (cnt < 0) { // 마이너스 된 경우 0으로 세팅해줌
                this.cnt = 0
            } else {
                this.cnt = cnt
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            solution.solution(arrayOf(arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"), arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"), arrayOf(
                    "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"), arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"), arrayOf(
                    "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")))
        }
    }
}