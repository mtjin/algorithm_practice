import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ropes = new int[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = sc.nextInt();
        }
        Arrays.sort(ropes);
        int count = 1;
        int max = 0;
        int prev = 0;
        for (int i = ropes.length - 1; i >= 0; i--) {
            max = Math.max(prev + ropes[i] * count, max);
            count++;
        }
        System.out.println(max);
    }

}