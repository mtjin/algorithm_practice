import java.util.*

internal class Solution {
    fun solution(answers: IntArray): IntArray {
        val score = IntArray(3)
        val a = intArrayOf(1, 2, 3, 4, 5)
        val b = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val c = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        for (i in answers.indices) {
            if (answers[i] == a[i % a.size]) score[0]++
            if (answers[i] == b[i % b.size]) score[1]++
            if (answers[i] == c[i % c.size]) score[2]++
        }
        val max = score[0].coerceAtLeast(score[1].coerceAtLeast(score[2]))
        val list: MutableList<Int> = ArrayList()
        if (max == score[0]) {
            list.add(1)
        }
        if (max == score[1]) {
            list.add(2)
        }
        if (max == score[2]) {
            list.add(3)
        }
        val answer = IntArray(list.size)
        for (i in list.indices) {
            answer[i] = list[i]
        }
        return answer
    }
}