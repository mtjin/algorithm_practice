import java.util.ArrayList;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 0) {
            int div = n % 3;
            list.add(div);
            n /= 3;
            if (div == 1) {
                sb.insert(0, "1");
            } else if (div == 2) {
                sb.insert(0, "2");
            } else {
                sb.insert(0, "4");
            }
            if (div == 0) {
                n -= 1;
            }
        }
        return sb.toString();
    }
}