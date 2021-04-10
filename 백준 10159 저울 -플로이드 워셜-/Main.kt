import java.util.*

private var N // N개의 물건
        = 0
private var M // 미리 측정된 물건쌍의 개수
        = 0
private lateinit var weights: Array<IntArray>

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    weights = Array(N + 1) { IntArray(N + 1) }
    // 무게 대소관계 정리
    for (i in 1..M) {
        val start = sc.nextInt() // 더 무거운 물건
        val end = sc.nextInt() // 더 가벼운 물건
        weights[start][end] = 1 // 처음물건이 두번쨰물건모다 무겁다. 처음께(1차원배열) 두번째(2차원배열)보다 무거우면 1 세팅
        weights[end][start] = -1 // 반대의 경우는 -1 세팅
        // 대소관계모르는 경우 0
    }
    floyd()
    for (i in 1..N) {
        var cnt = N - 1 //자기자신 제외
        for (j in 1..N) {
            if (weights[i][j] != 0) { //대소관계 모르는 경우
                cnt--
            }
        }
        println(cnt)
    }
}

fun floyd() {
    for (k in 1..N) {
        for (i in 1..N) {
            for (j in 1..N) {
                if (weights[i][k] == weights[k][j] && weights[i][k] != 0) { //서로 비교할 수 있는 경우
                    weights[i][j] = weights[i][k] // i>k>j OR i<k<j 이므로 i,k 의 대소관계도 알 수 있게된다.
                }
            }
        }
    }
}