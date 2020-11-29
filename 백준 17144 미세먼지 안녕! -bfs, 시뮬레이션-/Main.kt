import java.util.*


//(6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000)
private var R //행
        = 0
private var C //열
        = 0
private var cleanR1 = -1 //공기청정기 위치(상단)
private var cleanC1 = -1
private var cleanR2 //공기청정기 위치(하단)
        = 0
private var cleanC2 = 0
private var T //시간초
        = 0
private lateinit var map: Array<IntArray>
private lateinit var newMap: Array<IntArray>
private val dr = intArrayOf(-1, 0, 1, 0)
private val dc = intArrayOf(0, -1, 0, 1)

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    R = sc.nextInt()
    C = sc.nextInt()
    T = sc.nextInt()
    map = Array(R) { IntArray(C) }
    for (i in 0 until R) {
        for (j in 0 until C) {
            map[i][j] = sc.nextInt()
            if (map[i][j] == -1) { //공기 청정기 위치
                if (cleanR1 == -1) { //상단 공기청정
                    cleanR1 = i
                    cleanC1 = j
                } else { //하단
                    cleanR2 = i
                    cleanC2 = j
                }
            }
        }
    }
    for (t in 0 until T) {
        newMap = Array(R) { IntArray(C) }
        newMap[cleanR1][cleanC1] = -1
        newMap[cleanR2][cleanC2] = -1
        for (i in 0 until R) {
            for (j in 0 until C) { //1.미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다
                if (map[i][j] >= 5) { //퍼질 수 있는 양의 미세먼지인 경우
                    bfs(i, j)
                } else { //퍼질 수 없는 경우 새로운 맵에 그냥 추가해줌
                    newMap[i][j] += map[i][j]
                }
            }
        }
        cloneMap() //map 재생성하고 newMap 값 복사
        makeNewMap() //newMap에 map 값 복사해서 초기화(바람이동에 영향없는 값 세팅을 위해)
        upCleaner(cleanR1, cleanC1 + 1)
        downCleaner(cleanR2, cleanC2 + 1)
        cloneMap()
    }
    println(sum())
}

private fun makeNewMap() { //newMap 값 세팅 (공기청정기에 영향이 안가는 바람 안쪽 값 세팅을 위해)
    for (i in 0 until R) {
        for (j in 0 until C) {
            newMap[i][j] = map[i][j]
        }
    }
}

private fun sum(): Int { //미세먼치 합
    var answer = 0
    for (i in 0 until R) {
        for (j in 0 until C) {
            if (map[i][j] >= 1) {
                answer += map[i][j]
            }
        }
    }
    return answer
}

private fun cloneMap() { //미세먼지 퍼진 뒤의 맵 복사(newMap -> map)
    map = Array(R) { IntArray(C) }
    for (i in 0 until R) {
        for (j in 0 until C) {
            map[i][j] = newMap[i][j]
        }
    }
    newMap = Array(R) { IntArray(C) } // 초기화
}

private fun bfs(r: Int, c: Int) { //미세먼지 퍼트리기(상하좌우)
    var spreadCnt = 0 //퍼트린 개수
    for (i in 0..3) {
        val r2 = r + dr[i]
        val c2 = c + dc[i]
        if (isCanSpread(r2, c2)) { //퍼트릴 수 있는 곳
            spreadCnt++
            newMap[r2][c2] += map[r][c] / 5
        }
    }
    //미세먼지 퍼트린만큼 원래 근원지 조정
    newMap[r][c] += map[r][c] - map[r][c] / 5 * spreadCnt
}

private fun isCanSpread(r: Int, c: Int): Boolean { //외부벽이나 공기청정기가 위치한게 아닌 곳
    return r >= 0 && r < R && c >= 0 && c < C && (r != cleanR1 || c != cleanC1) && (r != cleanR2 || c != cleanC2)
}

private fun upCleaner(r: Int, c: Int) { //상단공기청정기실행
    var r2 = r
    var c2 = c
    while (c2 < C - 1) { //우측이동
        newMap[r2][c2 + 1] = map[r2][c2]
        c2++
    }
    while (r2 > 0) { //상단이동
        newMap[r2 - 1][c2] = map[r2][c2]
        r2--
    }
    while (c2 > 0) { //좌측이동
        newMap[r2][c2 - 1] = map[r2][c2]
        c2--
    }
    while (r2 < r) { //하단이동
        newMap[r2 + 1][c2] = map[r2][c2]
        r2++
    }
    newMap[cleanR1][cleanC1 + 1] = 0 //가장 처음 공기청정기 미는 곳 0
    newMap[cleanR1][cleanC1] = -1 //원래 공기청정기 위치 리셋
}

private fun downCleaner(r: Int, c: Int) { //하단공기청정기실행
    var r2 = r
    var c2 = c
    while (c2 < C - 1) { //우측이동
        newMap[r2][c2 + 1] = map[r2][c2]
        c2++
    }
    while (r2 < R - 1) { //하단이동
        newMap[r2 + 1][c2] = map[r2][c2]
        r2++
    }
    while (c2 > 0) { //좌측이동
        newMap[r2][c2 - 1] = map[r2][c2]
        c2--
    }
    while (r2 > r) { //상단이동
        newMap[r2 - 1][c2] = map[r2][c2]
        r2--
    }
    newMap[cleanR2][cleanC2 + 1] = 0 //가장 처음 공기청정기 미는 곳 0
    newMap[cleanR2][cleanC2] = -1 //원래 공기청정기 위치 리셋
}
