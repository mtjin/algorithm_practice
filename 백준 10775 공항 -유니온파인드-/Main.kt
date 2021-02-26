import java.util.*

private var G // G개의 게이트
        = 0
private var P // P개의 게이트
        = 0
private lateinit var parent: IntArray
private var answer = 0
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    G = sc.nextInt()
    P = sc.nextInt()
    parent = IntArray(G + 1)
    for (i in 1..G) {
        parent[i] = i
    }
    for (i in 1..P) {
        val gate = sc.nextInt() // 게이트 번호
        val docking = find(gate) // 도킹될 번호 (0이면 더이상 도킹 불가하므로 폐쇄)
        if (docking == 0) break
        answer++
        union(docking, docking - 1) // 다음번 중복 도킹방지를 위해 자신보다 낮은번호로 도킹되게끔 Union (최종적으론 0을 바라봄)
    }
    println(answer)
}

private fun union(x: Int, y: Int) {
    var x = x
    var y = y
    x = find(x)
    y = find(y)
    if (x != y) {
        if (x < y) parent[y] = x else parent[x] = y
    }
}

private fun find(x: Int): Int {
    return if (parent[x] == x) x else find(parent[x]).also { parent[x] = it }
}
