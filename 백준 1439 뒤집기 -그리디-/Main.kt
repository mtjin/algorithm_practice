import java.util.*

private lateinit var S: String
private lateinit var nums: IntArray

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    S = sc.next()
    nums = IntArray(S.length)
    for (i in S.indices) {
        nums[i] = S.get(i).toString().toInt()
    }
    var zeroCnt = 0
    var oneCnt = 0
    var prevNum = -1
    for (i in nums.indices) {
        val num = nums[i]
        if (num != prevNum) {
            if (num == 0) {
                zeroCnt++
            } else { //1
                oneCnt++
            }
        }
        prevNum = num
    }
    println(zeroCnt.coerceAtMost(oneCnt))
}