import java.util.*

private var V // V개의 마을
        = 0
private var E // E개의 도로
        = 0
private lateinit var distance // 도로의 최소거리
        : Array<IntArray>
private const val INF = 10000 * 400 + 1
private var answer = 10000 * 400 + 1


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    V = sc.nextInt()
    E = sc.nextInt()
    distance = Array(V + 1) { IntArray(V + 1) }
    //초기화
    for (i in 1..V) {
        Arrays.fill(distance[i], INF)
    }
    for (i in 0 until E) {
        val start = sc.nextInt() // a번 마을
        val end = sc.nextInt() // b번 마을
        val cost = sc.nextInt()
        distance[start][end] = cost //(a, b) 쌍이 같은 도로가 여러 번 주어지지 않는다.
        // distance[end][start] = cost; // (a → b임에 주의)
    }
    floyd()
    // 최소 사이클 중 최솟값을 구한다.
    for (i in 1..V) {
        answer = distance[i][i].coerceAtMost(answer)
    }
    if (answer == INF) {
        println(-1)
    } else {
        println(answer)
    }
}

fun floyd() {
    for (k in 1..V) {
        for (i in 1..V) {
            for (j in 1..V) {
                distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j])
            }
        }
    }
}