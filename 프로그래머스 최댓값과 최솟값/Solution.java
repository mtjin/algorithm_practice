class Solution {

    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] strArr = s.split(" ");
        for (String str : strArr) {
            int n = Integer.parseInt(str);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        String answer = min + " " + max;
        return answer;
    }
}