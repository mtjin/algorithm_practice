import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val t = arrayOfNulls<Int>(N)
    for (i in 0 until N) {
        t[i] = sc.nextInt()
    }
    // 오래걸리는거부터 심어야 최대한 빠르므로 역정렬
    Arrays.sort(t, Collections.reverseOrder())
    var maxDay = 0
    for (i in 0 until N) { // 나무자라는데걸리는시간 + 며칠지났는지 + 심는데 하루
        maxDay = Math.max(maxDay, t[i]!! + i + 1)
    }
    // 다 심은 다음날 이장님 초대 가능
    maxDay += 1
    println(maxDay)
}