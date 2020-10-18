import java.util.*

private lateinit var map: Array<IntArray>
private var zero = 0
private var one = 0
private var minus1 = 0

private fun dfs(n: Int, x: Int, y: Int) {
    if (n == 1) {
        when (map[y][x]) {
            -1 -> {
                minus1++
            }
            0 -> {
                zero++
            }
            else -> {
                one++
            }
        }
        return
    }
    if (isSame(n, x, y)) {
        return
    }
    dfs(n / 3, x, y)
    dfs(n / 3, x + n / 3, y)
    dfs(n / 3, x + 2 * n / 3, y)
    dfs(n / 3, x, y + n / 3)
    dfs(n / 3, x, y + 2 * n / 3)
    dfs(n / 3, x + n / 3, y + n / 3)
    dfs(n / 3, x + n / 3, y + 2 * n / 3)
    dfs(n / 3, x + 2 * n / 3, y + n / 3)
    dfs(n / 3, x + 2 * n / 3, y + 2 * n / 3)
}

private fun isSame(n: Int, x: Int, y: Int): Boolean {
    val first = map[y][x]
    for (i in y until y + n) {
        for (j in x until x + n) {
            if (first != map[i][j]) {
                return false
            }
        }
    }
    //해당 종이 하나로 압축
    when (first) {
        0 -> {
            zero++
        }
        1 -> {
            one++
        }
        else -> {
            minus1++
        }
    }
    return true
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val size = sc.nextInt()
    map = Array(size) { IntArray(size) }
    for (i in 0 until size) {
        for (j in 0 until size) {
            map[i][j] = sc.nextInt()
        }
    }
    dfs(size, 0, 0)
    println(minus1)
    println(zero)
    println(one)
}