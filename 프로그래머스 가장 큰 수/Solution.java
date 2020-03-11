import java.util.ArrayList;
import java.util.Collections;

class Solution {

    /*public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{0,0,0,110,1});
    }*/

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        ArrayList<BiggestNum> biggestNumArrayList = new ArrayList<>();
        for (int num : numbers) {
            biggestNumArrayList.add(new BiggestNum(String.valueOf(num)));
        }
        Collections.sort(biggestNumArrayList);
        ArrayList<String> zeroList = new ArrayList<>();
        for (BiggestNum biggestNum : biggestNumArrayList) {
            if (biggestNum.num.startsWith("0")) {
                zeroList.add(biggestNum.num);
            } else {
                answer.append(biggestNum.num);
            }
        }
        for(String zero : zeroList){
            answer.append(zero);
        }

        // 000000 -> 0 출력되야함
        if(answer.toString().startsWith("0")){
            return "0";
        }else{
            return answer.toString();
        }
    }

    class BiggestNum implements Comparable<BiggestNum> {
        String num;

        BiggestNum(String num) {
            this.num = num;
        }

        @Override
        public int compareTo(BiggestNum o) {
            String a = num + o.num;
            String b = o.num + num;
            return Integer.compare(Integer.parseInt(b), Integer.parseInt(a));
        }
    }
}