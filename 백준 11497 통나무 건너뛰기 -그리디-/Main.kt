import java.util.*
import kotlin.math.abs

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val T = sc.nextInt() // 테스트 케이스 수
    for (t in 0 until T) {
        val N = sc.nextInt() // 통나무 개수
        val arr = IntArray(N)
        for (i in 0 until N) {
            arr[i] = sc.nextInt()
        }
        Arrays.sort(arr) // 정렬
        var left = N - 1
        var right = 0
        val nums = IntArray(N)
        // 왼쪽 오른쪽에 하나씩 정렬된 통나무를 놓으면 가장 작은 차이를 만들 수 있음
        for (i in 0 until N) {
            if (i % 2 == 0) {
                nums[left--] = arr[i]
            } else {
                nums[right++] = arr[i]
            }
        }
        // 인접한것들끼리의 크기비교
        var answer = Int.MIN_VALUE
        for (i in 1 until N) {
            answer = answer.coerceAtLeast(abs(nums[i] - nums[i - 1]))
        }
        // 처음과 끝 통나무도 크기비교
        answer = answer.coerceAtLeast(abs(nums[0] - nums[N - 1]))
        println("$answer ")
    }
}
