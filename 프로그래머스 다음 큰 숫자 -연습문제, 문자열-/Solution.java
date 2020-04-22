class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(78);
    }
    public int solution(int n) {
        int answer = n;
        int nCount = 0; // 입력 이진수 1의 개수
        String str = Integer.toBinaryString(n);
        for (int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                nCount++;
            }
        }
        while (true){
            ++answer;
            int count = 0; // 다음숫자 이진수 1의 개수
            str = Integer.toBinaryString(answer);
            for (int i=0; i<str.length(); i++){
                if(str.charAt(i) == '1'){
                    count++;
                }
            }
            if(count == nCount){
                break;
            }
        }
        return answer;
    }
}