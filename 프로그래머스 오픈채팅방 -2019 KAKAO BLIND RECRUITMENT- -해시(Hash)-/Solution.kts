import java.util.*
class Solution {

    fun solution(record: Array<String>): Array<String> {
        val map = HashMap<String, String>()
        val result = ArrayList<String>()
        val answer: Array<String>

        for (str in record) {
            when (str.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]) {
                "Enter", "Change" -> {
                    val uid = str.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
                    val name = str.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[2]
                    map[uid] = name
                }
            }

        }
        for (str in record) {
            when (str.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]) {
                "Enter" -> result.add(map.get(str.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]) + "님이 들어왔습니다.")
                "Leave" -> result.add(map.get(str.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]) + "님이 나갔습니다.")
            }
        }
        answer = result.toTypedArray()
        return answer
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val solution = Solution()
            solution.solution(arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"))
        }
    }
}