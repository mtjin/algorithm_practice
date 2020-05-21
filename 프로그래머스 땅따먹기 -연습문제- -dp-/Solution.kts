internal class Solution {
    fun solution(land: Array<IntArray>): Int {
        var answer = 0
        for (i in 1 until land.size) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]))
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]))
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]))
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]))
        }
        answer = Math.max(land[land.size - 1][0], Math.max(land[land.size - 1][1], Math.max(land[land.size - 1][2], land[land.size - 1][3])))
        return answer
    }
}