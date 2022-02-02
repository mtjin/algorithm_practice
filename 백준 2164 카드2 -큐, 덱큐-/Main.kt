import java.util.*


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val deque: Deque<Int> = ArrayDeque()
    // 1. 초기화
    for (i in 1..N) {
        deque.add(i)
    }
    // 한 장 남을때까지 반복
    while (deque.size > 1) { // 2. 맨 위 카드 버리기
        deque.pollFirst()
        // 3. 맨 위 카드 맨밑으로 옮기기
        deque.offerLast(deque.pollFirst())
    }
    // 마지막 카드 정답 출력
    println(deque.poll())
}