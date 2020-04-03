import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 계단 개수
        int[] stairs = new int[n + 1];
        int[] result = new int[n + 1];
        // 계단 값 초기화
        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }
        // 첫 두 계단 세팅과 2 이하의 경우 예외처리
        if (n > 2) {
            result[1] = stairs[1];
            result[2] = stairs[1] + stairs[2];
        } else {
            if (n == 1) {
                System.out.println(stairs[1]);
                return;
            } else {
                System.out.println(stairs[1] + stairs[2]);
                return;
            }
        }
        for (int i = 3; i <= n; i++) {
            // 2->1->현재 OR  2->현재(stairs[i]) 중 최댓값
            result[i] = Math.max(result[i - 3] + stairs[i - 1] + stairs[i], result[i - 2]  + stairs[i]);
        }
        System.out.println(result[n]);
    }
}