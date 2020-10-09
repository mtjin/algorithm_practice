package kotlin

class Solution {
    fun solution(N: Int, number: Int): Int {
        Companion.N = N
        Companion.number = number
        dfs(0, 0)
        if (answer == 9) answer = -1
        return answer
    }

    companion object {
        private var N = 0
        private var number = 0
        private var answer = 9
        private fun dfs(count: Int, prev: Int) {
            if (count > 8) {
                answer = -1
                return
            }
            if (number == prev && answer > count) { //답과 같고 최소의 답인 경우
                answer = count
                return
            }
            var n2 = N
            for (i in 0 until 8 - count) { // 남은 최소 개수만큼  5, 55,555... 사칙연산 경우의 수 모두 탐색
                dfs(count + i + 1, prev + n2)
                dfs(count + i + 1, prev - n2)
                dfs(count + i + 1, prev * n2)
                dfs(count + i + 1, prev / n2)
                n2 += N * Math.pow(10.0, i + 1.toDouble()).toInt() //5, 55, 555, 5555..
            }
        }
    }
}