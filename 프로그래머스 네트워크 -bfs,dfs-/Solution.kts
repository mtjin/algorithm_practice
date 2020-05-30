internal class Solution {

    fun solution(n: Int, computers: Array<IntArray>): Int {
        Solution.n = n
        map = Array(n) { IntArray(n) }
        isVisited = BooleanArray(n)
        answer = n

        for (i in 0 until n) {
            for (j in 0 until n) {
                map[i][j] = computers[i][j]
            }
        }
        for (i in 0 until n) {
            dfs(i)
        }
        return answer
    }

    companion object {
        private lateinit var map: Array<IntArray>
        private lateinit var isVisited: BooleanArray
        private var n: Int = 0
        private var answer = 0

        private fun dfs(start: Int) {
            if (isVisited[start]) {
                return
            }
            isVisited[start] = true
            for (j in 0 until n) {
                if (map[start][j] == 1 && isVisited[j] == false) {
                    dfs(j)
                    answer-- // 붙어 있는거면 전체 네트워크 개수 - 1
                }
            }
        }
    }
}