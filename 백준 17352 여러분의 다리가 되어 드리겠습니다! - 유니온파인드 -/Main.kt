import java.util.*


private var N = 0
private lateinit var parent: IntArray
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    parent = IntArray(N + 1)
    // 1, 초기화
    for (i in 1..N) {
        parent[i] = i
    }
    // 2. 유니온
    for (i in 0 until N - 2) {
        val start = sc.nextInt()
        val end = sc.nextInt()
        union(start, end)
    }
    // 3. 다리 체크 및 이어주기
    for (i in 2..N) {
        if (!isSameParent(1, i)) {
            print("1 $i")
            return
        }
    }
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

private fun isSameParent(x: Int, y: Int): Boolean {
    return find(x) == find(y)
}

private fun find(x: Int): Int {
    return if (parent[x] == x) {
        x
    } else {
        find(parent[x]).also { parent[x] = it }
    }
}
