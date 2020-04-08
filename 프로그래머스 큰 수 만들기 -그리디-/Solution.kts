class Solution {
    fun solution(number: String, k: Int): String {
        val answer = StringBuilder(number)
        var completeCnt = 0
        while (completeCnt < k) {
            for (i in 0 until answer.length - 1) {
                if (answer[i].toInt() == 9) {
                    continue
                }
                if (answer[i] < answer[i + 1]) {
                    answer.deleteCharAt(i)
                    completeCnt++
                    break
                }
                if (i == answer.length - 2) {
                    answer.deleteCharAt(i + 1)
                    completeCnt++
                    break
                }
            }
        }
        return answer.toString()
    }
}