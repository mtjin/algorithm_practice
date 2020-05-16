    internal class Solution {

        fun solution(numbers: IntArray, target: Int): Int {
            size = numbers.size //5
            Solution.target = target //3
            Solution.numbers = numbers
            dfs(numbers[0], 0) // 1
            dfs(numbers[0] * -1, 0) // -1
            return answer
        }

        companion object {
            private var target: Int = 0
            private var size: Int = 0
            private var answer = 0
            private var numbers: IntArray? = null

            fun dfs(n: Int, count: Int) {
                if (count == size - 1) {
                    if (n == target) {
                        answer++
                    }
                } else {
                    dfs(n + numbers!![count + 1], count + 1)
                    dfs(n + numbers!![count + 1] * -1, count + 1)
                }
            }
        }
    }