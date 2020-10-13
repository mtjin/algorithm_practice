import java.util.*

internal class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val queue: Queue<Int> = LinkedList()
        val result = ArrayList<Int>()
        for (i in progresses.indices) {
            val day = Math.ceil((100 - progresses[i]).toDouble() / speeds[i]).toInt()
            queue.offer(day)
        }
        var prev = queue.poll()
        var count = 1
        while (!queue.isEmpty()) {
            val now = queue.poll()
            if (prev >= now) {
                count++
            } else {
                result.add(count)
                count = 1
                prev = now
            }
        }
        result.add(count)
        val answer = IntArray(result.size)
        for (i in answer.indices) {
            answer[i] = result[i]
        }
        return answer
    }
}