internal class Solution {

    fun solution(dirs: String): Int {
        var answer = 0
        val isVisited = Array(11) { Array(11) { Array(11) { BooleanArray(11) } } } // (x,y) -> (x,y) 로 이동한 적 있는지
        var x: Int = 5 //현재좌표
        var y: Int = 5
        var x2: Int = 5 //이동할좌표
        var y2: Int = 5
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, -1, 0, 1)
        for (move in dirs.toCharArray()) {
            x = x2
            y = y2
            when (move) {
                'L' -> { //좌하우상
                    x2 = x + dx[0]
                    y2 = y + dy[0]
                }
                'D' -> {
                    x2 = x + dx[1]
                    y2 = y + dy[1]
                }
                'R' -> {
                    x2 = x + dx[2]
                    y2 = y + dy[2]
                }
                else -> {
                    x2 = x + dx[3]
                    y2 = y + dy[3]
                }
            }

            //범위벗어난거처리
            if (x2 < 0 || x2 > 10 || y2 < 0 || y2 > 10) {
                //이동하기 전 좌표로 바꿔줌
                x2 = x
                y2 = y
                continue
            }

            //이동가능한 좌표, 첫방문이면 답 +1
            if (!isVisited[x][y][x2][y2]) {
                isVisited[x][y][x2][y2] = true
                isVisited[x2][y2][x][y] = true
                answer++
            }
        }

        return answer
    }
}