import java.util.*

class Solution {
    var size = 0
    private lateinit var tickets: Array<Array<String>>
    var resultList = ArrayList<String>()

    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer = arrayOf<String>()
        var isVisited: BooleanArray
        this.tickets = tickets
        size = tickets.size
        for (i in tickets.indices) {
            if (tickets[i][0] == "ICN") {
                isVisited = BooleanArray(tickets.size)
                val start = tickets[i][0]
                val end = tickets[i][1]
                val history = tickets[i][0]
                isVisited[i] = true
                val flight = Flight(start, end, history, 1, isVisited)
                dfs(flight)
            }
        }
        //정렬
        resultList.sort()
        answer = resultList[0].split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return answer
    }

    private fun dfs(flight: Flight) {
        for (i in 0 until size) {
            if (flight.cnt == size) {
                val history = flight.history + "," + flight.end
                resultList.add(history)
                continue
            }
            val isVisited = flight.isVisited.clone()
            val currentEnd = flight.end
            val nextStart = tickets[i][0]
            if (!isVisited[i] && currentEnd == nextStart) {
                val history = flight.history + "," + nextStart
                isVisited[i] = true
                dfs(Flight(tickets[i][0], tickets[i][1], history, flight.cnt + 1, isVisited))
            }
        }
    }

    data class Flight(var start: String //출발지
                      , var end: String //도착지
                      , var history: String //기록
                      , var cnt: Int // 공항 이동 총 횟수
                      , var isVisited: BooleanArray // 공항 방문 여부
    )
}