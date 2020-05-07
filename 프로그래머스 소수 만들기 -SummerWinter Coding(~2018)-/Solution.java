class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1,2,3,4});
    }
    public static int answer = 0;
    public int solution(int[] nums) {
        int n = 0;
        for (int i=0; i<nums.length-2; i++){
            for (int j=i+1; j<nums.length-1; j++){
                for (int k=j+1; k<nums.length; k++ ){
                    isSosu(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        return answer;
    }

    public void isSosu(int num){
        int i = 2;
        while (i*i<=num){
            if(num%i == 0){
                //소수아님
                return;
            }
            i+=1;
        }
        //소수
        answer++;
    }
}