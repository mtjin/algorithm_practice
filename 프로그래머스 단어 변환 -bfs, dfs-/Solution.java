import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    // 현재단어에서 단어 변경 하나만 할 수 있는 경우만 변환 가능
    public static boolean isConvert(String word, String convertWord) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != convertWord.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] isVisited = new boolean[words.length];
        List<String> wordList = Arrays.asList(words);
        if (!wordList.contains(target)) { // target 단어 안가지고 있는 경우
            return 0;
        }

        //bfs
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));
        while (!queue.isEmpty()) {
            Word currentWord = queue.poll();
            if (currentWord.word.equals(target)) {
                answer = currentWord.cnt;
                break;
            }
            for (int i = 0; i < words.length; i++) {
                if (!isVisited[i] && isConvert(currentWord.word, words[i])) {
                    isVisited[i] = true;
                    queue.offer(new Word(words[i], currentWord.cnt + 1));
                }
            }
        }
        return answer;
    }

    static class Word {
        String word; // 단어
        int cnt; // 변경한 횟수

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}