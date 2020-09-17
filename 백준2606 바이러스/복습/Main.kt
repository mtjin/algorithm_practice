package kotlin

import java.util.*


lateinit var map: Array<IntArray>
lateinit var bfsVisited: BooleanArray
private var virusCnt = 0 //바이러스 걸리게되는 컴퓨터 수
private var N: Int = 0 //컴퓨터 수


fun main(vararg args: String) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    map = Array(N + 1) { IntArray(N + 1) }
    bfsVisited = BooleanArray(N + 1)
    val comSize = sc.nextInt()
    for (i in 1..comSize) {
        val node1 = sc.nextInt()
        val node2 = sc.nextInt()
        map[node1][node2] = 1
        map[node2][node1] = 1
    }
    bfs(1)
    println(virusCnt)
}

fun bfs(currentNode: Int) {
    var currentNode = currentNode
    val queue = LinkedList<Int>()
    queue.offer(currentNode)
    bfsVisited[currentNode] = true
    while (!queue.isEmpty()) {
        currentNode = queue.poll()
        for (i in 1..N) {
            if (map[currentNode][i] == 1 && !bfsVisited[i]) {
                queue.offer(i)
                bfsVisited[i] = true
                virusCnt++
            }
        }
    }
}


