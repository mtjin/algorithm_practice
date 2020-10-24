import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int[] arr = new int[W];
        int answer = 0;
        for (int i = 0; i < W; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < W - 1; i++) {
            int current = arr[i];
            int leftMax = current;
            int rightMax = current;
            for (int k = i - 1; k >= 0; k--) {
                if (arr[k] > current) {
                    leftMax = Math.max(leftMax, arr[k]);
                }
            }
            for (int k = i + 1; k < W; k++) {
                if (arr[k] > current) {
                    rightMax = Math.max(rightMax, arr[k]);
                }
            }
            if (Math.min(leftMax, rightMax) > current) {
                answer += (Math.min(leftMax, rightMax) - arr[i]);
            }
        }
        System.out.println(answer);
    }
}