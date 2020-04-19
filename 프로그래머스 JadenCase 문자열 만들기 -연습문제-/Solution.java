class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("3people    DnFollowed  sa23da me   444ASSDD");
    }

    public String solution(String s) {
        int i = 0;
        boolean isNewWord = true;
        StringBuilder answer = new StringBuilder(s);
        while (i < s.length()) {
            Character ch = s.charAt(i);
            if (isNewWord && !(ch.equals(' '))) {
                if (Character.isLowerCase(ch)) {
                    answer.replace(i, i + 1, ch.toString().toUpperCase());
                    isNewWord = false;
                    i++;
                    continue;
                }else if(Character.isUpperCase(ch)){
                    isNewWord = false;
                    i++;
                    continue;
                }
                isNewWord = false;
            } else if (ch.equals(' ')) {
                isNewWord = true;
            }
            if (Character.isUpperCase(ch) && !isNewWord) {
                answer.replace(i, i + 1, ch.toString().toLowerCase());
            }
            i++;
        }
        return answer.toString();
    }
}