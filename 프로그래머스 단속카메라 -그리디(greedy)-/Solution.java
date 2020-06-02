import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}});
    }

    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int min = -30001;
        for (int i = 0; i < routes.length; i++) {
            if(routes[i][0] > min){
                answer++;
                min = routes[i][1];
            }
        }

        return answer;
    }
}