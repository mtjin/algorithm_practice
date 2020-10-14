package a

class Solution {
    private lateinit var map: Array<IntArray>
    private var zero = 0
    private var one = 0
    fun solution(arr: Array<IntArray>): IntArray {
        val answer = IntArray(2)
        map = arr
        dfs(arr.size, 0, 0)
        answer[0] = zero
        answer[1] = one
        return answer
    }

    private fun dfs(n: Int, x: Int, y: Int) {
        if (n == 1) {
            if (map[x][y] == 1) {
                one++
            } else {
                zero++
            }
            return
        }
        if (isSame(n, x, y)) {
            return
        }
        dfs(n / 2, x, y)
        dfs(n / 2, x + n / 2, y)
        dfs(n / 2, x, y + n / 2)
        dfs(n / 2, x + n / 2, y + n / 2)
    }

    private fun isSame(n: Int, x: Int, y: Int): Boolean {
        val first = map[x][y]
        for (i in x until x + n) {
            for (j in y until y + n) {
                if (first != map[i][j]) {
                    return false
                }
            }
        }
        if (first == 0) {
            zero += 1
        } else {
            one += 1
        }
        return true
    }

}