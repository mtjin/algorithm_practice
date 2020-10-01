import java.util.*

internal var map = Array(9) { IntArray(9) }
internal var list: LinkedList<Node> = LinkedList()

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    for (i in 0..8) {
        for (j in 0..8) {
            map[i][j] = sc.nextInt()
            if (map[i][j] == 0) {
                list.add(Node(i, j))
            }
        }
    }
    dfs(0)
}

internal fun dfs(depth: Int) {
    if (depth == list.size) {
        for (i in 0..8) {
            for (j in 0..8) {
                print(map[i][j].toString() + " ")
            }
            println()
        }
        System.exit(0)
    }
    val node = list[depth]
    val x = node.x
    val y = node.y
    for (i in 1..9) { //빈칸인 map[x][y]에 1~9 값 되는지 check
        if (check(x, y, i)) {
            map[x][y] = i //되는 숫자면 넣고 이어서 탐색
            dfs(depth + 1)
            map[x][y] = 0
        }
    }
}

internal fun check(x: Int, y: Int, num: Int): Boolean {
    if (map[x][y] != 0) { // 빈칸 아니면 false
        return false
    }
    for (i in 0..8) { //가로,세로줄 중복검사
        if (map[i][y] == num || map[x][i] == num) {
            return false
        }
    }
    val x2 = x / 3 * 3
    val y2 = y / 3 * 3
    for (i in x2 until x2 + 3) { //3x3 중복체크
        for (j in y2 until y2 + 3) {
            if (map[i][j] == num) {
                return false
            }
        }
    }
    return true

}


data class Node(var x: Int, var y: Int)