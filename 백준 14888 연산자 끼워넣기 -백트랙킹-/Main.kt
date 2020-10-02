import java.util.*

private val opArr = IntArray(4)
lateinit var numArr: IntArray
private var max = Integer.MIN_VALUE
private var min = Integer.MAX_VALUE


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val size = sc.nextInt()
    numArr = IntArray(size)
    for (i in numArr.indices) {
        numArr[i] = sc.nextInt()
    }
    for (i in opArr.indices) {
        opArr[i] = sc.nextInt()
    }
    dfs(numArr[0], 1)
    println(max)
    println(min)
}

private fun dfs(num: Int, index: Int) {
    if (index == numArr.size) {
        max = Math.max(max, num)
        min = Math.min(min, num)
        return
    }
    for (i in opArr.indices) {
        if (opArr[i] > 0) {
            opArr[i]--
            if (i == 0) {
                dfs(num + numArr[index], index + 1)
            } else if (i == 1) {
                dfs(num - numArr[index], index + 1)
            } else if (i == 2) {
                dfs(num * numArr[index], index + 1)
            } else {
                dfs(num / numArr[index], index + 1)
            }
            opArr[i]++
        }
    }

}