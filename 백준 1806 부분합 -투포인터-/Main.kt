import java.util.*

private var N // 10 ≤ N < 100,000
        = 0
private var S = 0
private var left = 0
private var right = 0
private var answer = 100001
private var sum = 0
private lateinit var nums: IntArray

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    N = sc.nextInt()
    S = sc.nextInt()
    nums = IntArray(N)
    for (i in 0 until N) {
        nums[i] = sc.nextInt()
    }
    while (true) {
        if (sum >= S) { //조건 만족
            sum -= nums[left]
            answer = Math.min(answer, right - left) // 부분합 최소 길이 갱신
            left++ // 왼쪽 포인터 오른쪽으로 이동
        } else if (right == N) { //끝 도달
            break
        } else { // right포인터 오른쪽으로 이동
            sum += nums[right++]
        }
    }
    if (answer == 100001) {
        println(0)
    } else {
        println(answer)
    }
}