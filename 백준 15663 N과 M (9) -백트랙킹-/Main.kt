import java.util.*


private var N = 0
private var M = 0
private lateinit var nums: IntArray
private lateinit var arr: IntArray
private lateinit var isVisited: BooleanArray
private val set = HashSet<String>()
private val sb = StringBuilder()

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    nums = IntArray(N)
    arr = IntArray(M)
    isVisited = BooleanArray(N)
    for (i in 0 until N) {
        nums[i] = sc.nextInt()
    }
    Arrays.sort(nums)
    dfs(0)
    println(sb.toString())
}

private fun dfs(depth: Int) {
    if (depth == M) {
        val sb2 = StringBuilder()
        for (i in 0 until M) {
            sb2.append(arr[i]).append(" ")
        }
        if (!set.contains(sb2.toString())) { // 중복제거
            sb.append(sb2.toString()).append("\n")
            set.add(sb2.toString())
        }
        return
    }
    for (i in 0 until N) {
        if (!isVisited[i]) {
            isVisited[i] = true
            arr[depth] = nums[i]
            dfs(depth + 1)
            isVisited[i] = false
        }
    }
}
