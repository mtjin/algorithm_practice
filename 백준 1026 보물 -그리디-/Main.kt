package kotlin

import java.util.*


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val A = IntArray(N)
    val B = IntArray(N)
    for (i in 0 until N) {
        A[i] = sc.nextInt()
    }
    for (i in 0 until N) {
        B[i] = sc.nextInt()
    }
    Arrays.sort(A)
    Arrays.sort(B)
    var S = 0
    for (i in 0 until N) {
        S += A[i] * B[N - 1 - i]
    }
    println(S)
}

