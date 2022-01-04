import java.util.*

private var N = 0
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    val isVisited = BooleanArray(N + 1)
    dfs(0, isVisited, IntArray(N))
}

private fun dfs(depth: Int, isVisited: BooleanArray, nums: IntArray) {
    if (depth == N) {
        for (i in nums.indices) {
            print(nums[i].toString() + " ")
        }
        println()
        return
    }
    for (i in 1..N) {
        if (!isVisited[i]) {
            isVisited[i] = true
            nums[depth] = i
            dfs(depth + 1, isVisited, nums)
            isVisited[i] = false
        }
    }
}