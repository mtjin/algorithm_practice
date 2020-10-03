import java.util.Scanner;

public class Main {
    private static int[] num;
    private static int left = 0;
    private static int right = 0;
    private static int result = 0;
    private static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        num = new int[n];
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
        }
        while (true) {
            if (sum >= m) {
                sum -= num[left++];
            }else if(right == n){
                break;
            } else {
                sum += num[right++];
            }
            if (sum == m) {
                result++;
            }
        }
        System.out.println(result);


    }
}