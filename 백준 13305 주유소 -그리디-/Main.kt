import java.util.*

private var N // 도시의 개수
        = 0
private lateinit var distances // 거리
        : LongArray
private lateinit var costs // 비용
        : LongArray
private var sum: Long = 0 // 총 비용 (답)


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    distances = LongArray(N - 1)
    costs = LongArray(N)
    for (i in 0 until N - 1) {
        distances[i] = sc.nextLong()
    }
    for (i in 0 until N) {
        costs[i] = sc.nextLong()
    }
    //첫번째 도시 출발지점 초기화
    var minCost = costs[0]
    sum = minCost * distances[0]
    //두번째도시 ~~ 마지막도시
    for (i in 1 until N - 1) {
        if (costs[i] < minCost) { //최소 기름값 업데이트
            minCost = costs[i]
        }
        sum += minCost * distances[i]
    }
    println(sum)
}