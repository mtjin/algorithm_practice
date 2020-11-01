import java.util.*

private lateinit var arr: Array<String?>
private lateinit var nums: Array<String?>
private lateinit var isVisited: BooleanArray
private var L = 0
private var C = 0
private val sb = StringBuilder()


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    L = sc.nextInt() //조합길이
    C = sc.nextInt() //알파벳총개수(중복없음)
    arr = arrayOfNulls(C)
    nums = arrayOfNulls(L)
    isVisited = BooleanArray(C)
    for (i in 0 until C) {
        arr[i] = sc.next()
    }
    Arrays.sort(arr)
    dfs(0)
    println(sb.toString())
}

private fun dfs(count: Int) {
    if (count == L) {
        if (!check(nums)) {
            return
        }
        for (i in 0 until L) {
            sb.append(nums[i])
        }
        sb.append("\n")
        return
    }
    for (i in 0 until C) {
        if (count == 0) {
            isVisited[i] = true
            nums[count] = arr[i]
            dfs(count + 1)
            isVisited[i] = false
        } else if (!isVisited[i]) {
            if (nums[count - 1]!! < arr[i]!!) {
                isVisited[i] = true
                nums[count] = arr[i]
                dfs(count + 1)
                isVisited[i] = false
            }
        }
    }
}

private fun check(str: Array<String?>): Boolean {
    var moeumCnt = 0
    var jaeumCnt = 0
    for (s in str) {
        if (isMoeum(s)) {
            moeumCnt++
        } else {
            jaeumCnt++
        }
    }
    return moeumCnt >= 1 && jaeumCnt >= 2
}

private fun isMoeum(s: String?): Boolean {
    return s == "a" || s == "e" || s == "i" || s == "o" || s == "u"
}