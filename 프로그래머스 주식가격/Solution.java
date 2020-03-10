
public class Solution {

     public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int cursor = 0; // answer index cursor

        int position = 0;
        while (position < prices.length) {
            int value = prices[position++];
            //남은 리스트에서 비교
            for(int i = position; i<prices.length; i++){
                int relativeValue = prices[i];
                // 가격이 떨어진 경우
                if(relativeValue < value){
                    answer[cursor++] = i-(position-1);
                    break;
                }
                //마지막까지 가격 안떨어진 경우
                else if(i == prices.length-1){
                    answer[cursor++] = i-(position-1);
                    break;
                }
            }
            //하나남은경우 0을 결과에 추가하고 break
            if(position == prices.length){
                answer[cursor] = 0;
                break;
            }
        }
        return answer;
    }

}
