import java.util.*

class Solution {

    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        val isVisited = BooleanArray(words.size)
        val wordList = Arrays.asList(*words)
        if (!wordList.contains(target)) { // target 단어 안가지고 있는 경우
            return 0
        }
        val queue = LinkedList<Word>()
        queue.offer(Word(begin, 0))

        while (!queue.isEmpty()) {
            with(queue.poll()) {
                if (this.word == target) {
                    answer = this.cnt
                    return answer
                }
                for (i in words.indices) {
                    if (!isVisited[i] && isConvert(this.word, words[i])) {
                        isVisited[i] = true
                        queue.offer(Word(words[i], this.cnt + 1))
                    }
                }
            }
        }
        return answer
    }

    data class Word(var word: String, var cnt: Int)

    companion object {
        fun isConvert(word: String, convertWord: String): Boolean {
            var count = 0
            for (i in 0 until word.length) {
                if (word[i] != convertWord[i]) {
                    count++
                }
                if (count > 1) {
                    return false
                }
            }
            return true
        }
    }
}