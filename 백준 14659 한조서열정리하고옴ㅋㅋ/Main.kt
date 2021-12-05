import java.util.*


private var answer = Int.MIN_VALUE
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt() // 활잡이의 수
    val arr = IntArray(N)
    for (i in 0 until N) {
        arr[i] = sc.nextInt()
    }
    for (i in 0 until N) {
        var count = 0
        for (j in i + 1 until N) {
            if (arr[i] > arr[j]) { // 자신보다 높은 봉우리면 킬
                count++
            } else { // 자신보다 낮은 봉우리면 포기
                break
            }
        }
        answer = answer.coerceAtLeast(count)
    }
    println(answer)
}
