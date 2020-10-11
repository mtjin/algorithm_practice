import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val list = ArrayList<String>()
    for (i in 0 until N) {
        val str = sc.next()
        if (!list.contains(str)) {
            list.add(str)
        }
    }
    list.sortWith(Comparator sort@{ o1: String, o2: String ->
        if (o1.length != o2.length) {
            return@sort o1.length - o2.length
        } else {
            return@sort o1.compareTo(o2)
        }
    })
    for (str in list) {
        println(str)
    }
}