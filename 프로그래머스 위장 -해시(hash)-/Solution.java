import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>(); // (의상의종류 , 옷개수)
        for (int i = 0; i < clothes.length; i++) {
            if (map.getOrDefault(clothes[i][1], 0) != 0) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }
        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        answer -= 1;
        return answer;
    }
}