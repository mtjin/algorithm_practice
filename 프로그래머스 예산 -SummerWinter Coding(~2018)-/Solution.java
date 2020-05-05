import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{2, 2, 3, 3}, 10);
    }

    public int solution(int[] d, int budget) {
        int i = 0;
        Arrays.sort(d);
        while (d[i] <= budget) {
            budget -= d[i++];
            if(d.length == i){
                break;
            }
        }
        System.out.println(i);
        return i;
    }
}