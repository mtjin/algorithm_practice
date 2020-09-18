import java.util.*

private var N: Int = 0 //수빈이 위치
private var M: Int = 0 //동생 위치
private val map = IntArray(100001)



fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    M = sc.nextInt()
    bfs()
    println(map[M])
}

internal fun bfs() {
    val queue = LinkedList<Int>()
    queue.offer(N)
    while (!queue.isEmpty()) {
        N = queue.poll()
        if (N == M) {
            break
        }
        if (N - 1 >= 0 && map[N - 1] == 0) {
            queue.offer(N - 1)
            map[N - 1] = map[N] + 1
        }
        if (N + 1 <= 100000 && map[N + 1] == 0) {
            queue.offer(N + 1)
            map[N + 1] = map[N] + 1
        }
        if (N * 2 <= 100000 && map[N * 2] == 0) {
            queue.offer(N * 2)
            map[N * 2] = map[N] + 1
        }
    }
}