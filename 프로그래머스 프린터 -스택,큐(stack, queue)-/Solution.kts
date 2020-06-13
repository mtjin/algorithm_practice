import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 1
        val queue = PriorityQueue(Comparator.reverseOrder<Int>()) // priorities 값
        for (i in priorities) {
            queue.offer(i)
        }
        while (!queue.isEmpty()) {
            for (i in priorities.indices) {
                if (priorities[i] == queue.peek()) {
                    if (location == i) {
                        return answer
                    }
                    answer++
                    queue.poll()
                }
            }
        }
        return answer
    }
}