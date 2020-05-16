import java.util.HashMap

internal class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val map : HashMap<String,Int> = HashMap<String, Int>() // (의상의종류 , 옷개수)
        for (i in clothes.indices) {
           clothes[i][1].let {
                clothType ->
                if (map.getOrDefault(clothType, 0) != 0) {
                    map[clothType] = map[clothType]!! + 1
                } else {
                    map[clothType] = 1
                }
            }
        }
        for (key in map.keys) {
            answer *= map[key]!! + 1
        }
        answer -= 1
        return answer
    }
}