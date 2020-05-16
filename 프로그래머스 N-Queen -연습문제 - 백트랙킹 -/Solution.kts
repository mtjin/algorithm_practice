internal class Solution {

    fun solution(n: Int): Int {
        N = n
        for (i in 1..n) {
            val map = IntArray(n + 1)
            map[1] = i
            dfs(map, 1)
        }
        return answer
    }

    companion object {
        var N: Int = 0
        var answer = 0

        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            solution.solution(8)
        }

        fun dfs(map: IntArray, row: Int) {
            if (row == N) { //마지막행까지 다 놓은 경우
                answer++
            } else {
                for (col in 1..N) {
                    map[row + 1] = col
                    if (check(map, row + 1)) {
                        // 놓을 수 있는 자리인 경우 다음행으로 재귀
                        dfs(map, row + 1)
                    }
                }
            }
        }

        fun check(map: IntArray, row: Int): Boolean {
            for (i in 1 until row) { // 이전 행들 반복문
                // 이전행의 같은 열에 체스가 있었는지
                if (map[i] == map[row]) {
                    return false
                }
                //대각선 공격 가능한지
                if (Math.abs(i - row) == Math.abs(map[i] - map[row])) {
                    return false
                }
            }
            return true
        }
    }
}