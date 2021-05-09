class Solution {
    private lateinit var weights: Array<IntArray>
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        weights = Array(n + 1) { IntArray(n + 1) }
        for (i in results.indices) {
            val win = results[i][0]
            val lose = results[i][1]
            weights[win][lose] = 1 //이김
            weights[lose][win] = -1 //짐
        }
        floyd(n)
        for (i in 1..n) {
            var cnt = 0
            for (j in 1..n) {
                if ((weights[i][j] != 0 || weights[j][i] != 0) && i != j) { // 해당 선수가 타 선수와의 승패를 아는 경우
                    cnt++
                }
            }
            if (cnt == n - 1) answer++ // 자신을 제외한 타선수와의 승패결과를 모두 아는 경우 순위확정 + 1
        }
        println(answer)
        return answer
    }

    private fun floyd(n: Int) {
        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    if (weights[i][k] == weights[k][j] && weights[i][k] != 0) { //서로 비교할 수 있는 경우
                        weights[i][j] = weights[i][k] // i>k>j OR i<k<j 이므로 i,k 의 대소관계도 알 수 있게된다.
                    }
                }
            }
        }
    }
}