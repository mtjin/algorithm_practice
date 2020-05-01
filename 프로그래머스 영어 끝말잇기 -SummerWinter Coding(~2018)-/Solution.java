import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(int n, String[] words) {
        int[] answer = {};
        List<String> history = new ArrayList<>(); //나왔던 단어들
        String preWord = ""; // 이전(최근)단어
        int count = 1; //차례
        for (int i = 0; i < words.length; i++) {
            if (history.contains(words[i])) { //이미 나온단어
                answer = new int[]{(i % n) + 1, count};
                break;
            }
            if (i != 0 && words[i].charAt(0) != preWord.charAt(preWord.length()-1)) { //앞글자 틀린 경우
                answer = new int[]{(i % n) + 1, count};
                break;
            }
            if ((i + 1) % n == 0) {// 한바퀴 돌았으니 차례 증가
                count++;
            }
            preWord = words[i];
            history.add(words[i]);
            if(i == words.length-1){ // 모두 맞는 끝말잇기인 경우
                answer = new int[]{0,0};
                break;
            }
        }
        return answer;
    }
}