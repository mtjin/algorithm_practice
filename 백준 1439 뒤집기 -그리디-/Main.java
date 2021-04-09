import java.util.Scanner;

class Main {
    private static String S;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        nums = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            nums[i] = Integer.parseInt(String.valueOf(S.charAt(i)));
        }
        int zeroCnt = 0;
        int oneCnt = 0;
        int prevNum = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != prevNum) {
                if (num == 0) {
                    zeroCnt++;
                } else { //1
                    oneCnt++;
                }
            }
            prevNum = num;
        }
        System.out.println(Math.min(zeroCnt, oneCnt));

    }
}