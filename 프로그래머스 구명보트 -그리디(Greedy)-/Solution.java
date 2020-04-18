import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{70, 80, 50}, 100);
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        int firstIndex = 0;
        int lastIndex = people.length - 1;
        Arrays.sort(people);
        while (lastIndex  - firstIndex >= 0){
            if(lastIndex - firstIndex >= 1){
                if(people[lastIndex] + people[firstIndex] <= limit){
                    firstIndex++;
                }
                lastIndex--;
                answer++;
            }else {
                answer++;
                lastIndex--;
            }
        }
        System.out.println(answer);
        return answer;
    }
}